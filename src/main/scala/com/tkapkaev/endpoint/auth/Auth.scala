package com.tkapkaev.endpoint.auth

import cats.effect.Sync
import com.tkapkaev.config.GeneralConfig
import com.tkapkaev.model.error.{ServiceError, Unauthorized}
import com.tkapkaev.model.user.{User, UserClaim}
import pdi.jwt.{JwtAlgorithm, JwtCirce}
import cats.syntax.functor._
import cats.syntax.either._
import cats.syntax.option._
import eu.timepit.refined.auto._
import com.tkapkaev.model.user.wrapping.JwtToken
trait Auth[F[_]] {
  def authenticate(token: String): F[Either[ServiceError, User]]
}

object Auth {

  class AuthImpl[F[_]: Sync](config: GeneralConfig) extends Auth[F] {
    override def authenticate(token: String): F[Either[ServiceError, User]] = {
      println(config)
      Sync[F].delay {
        for {
          claim <- JwtCirce.decodeJson(token, config.jwtPublicKey.value, JwtAlgorithm.allAsymmetric()).toEither
          user  <- claim.as[UserClaim].swap.widen[Throwable].swap

        } yield User(
          user.id,
          user.login,
          JwtToken(token),
          user.attributes
        )
      } map { _.leftMap(_ => ServiceError(Unauthorized, "Can't authorized user", none)) }

    }
  }

  def apply[F[_]: Sync](config: GeneralConfig): Auth[F] = new AuthImpl[F](config)
}
