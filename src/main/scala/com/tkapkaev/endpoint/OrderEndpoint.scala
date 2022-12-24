package com.tkapkaev.endpoint
import cats.Applicative
import cats.syntax.applicative._
import com.tkapkaev.config.GeneralConfig
import sttp.tapir._
class OrderEndpoint[F[_]: Applicative](generalConfig: GeneralConfig) {

  val baseEndpoint = endpoint
    .in(generalConfig.serviceName)
    .in("api" / "v1")

  val about = baseEndpoint.get
    .in("about")
    .out(emptyOutput)
    .serverLogicSuccess(_ => ().pure)

  val endpoints = about :: Nil

}

object OrderEndpoint {
  def apply[F[_]: Applicative](generalConfig: GeneralConfig): OrderEndpoint[F] = new OrderEndpoint[F](generalConfig)
}
