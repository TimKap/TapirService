package com.tkapkaev
import java.time.Instant

import scala.concurrent.duration.DurationInt

import cats.effect.kernel.Resource
import cats.effect.{ExitCode, IO, IOApp}
import cats.syntax.either._
import cats.syntax.flatMap._
import com.tkapkaev.config.Config
import com.tkapkaev.endpoint.OrderEndpoint
import com.tkapkaev.service.EmailService
import cron4s.Cron
import emil.{MailConfig, SSLType}
import eu.timepit.fs2cron.cron4s.Cron4sScheduler
import eu.timepit.refined.auto._
import fs2.Stream
import org.http4s.HttpApp
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.Server
import pureconfig.module.catseffect._
import sttp.tapir.server.http4s.Http4sServerInterpreter

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    for {
      config <- loadConfigF[IO, Config]
      app       = Http4sServerInterpreter[IO]().toRoutes(OrderEndpoint[IO](config.general).endpoints).orNotFound
      appStream = Stream.eval(server(app, config).useForever)

      mailService = EmailService[IO](
        MailConfig(
          "imaps://imap.yandex.ru:993",
          config.app.email,
          config.app.password,
          SSLType.SSL
        )
      )
      cronExpr <- Cron("15 * * ? * *").liftTo[IO]
      cronStream = Cron4sScheduler.systemDefault[IO].awakeEvery(cronExpr) >> Stream.eval(IO.delay(Instant.now()) >>= {
        now => IO.println(s"Start Task: $now") >> IO.sleep(2.seconds) >> IO.println(s"Finish Task: $now")
      })
      _ <- Stream.emits(List(appStream, cronStream)).parJoinUnbounded.compile.drain

    } yield ExitCode.Success

  }

  def server(app: HttpApp[IO], config: Config): Resource[IO, Server] =
    EmberServerBuilder
      .default[IO]
      .withPort(config.server.port)
      .withHost(config.server.host)
      .withHttpApp(app)
      .build

}
