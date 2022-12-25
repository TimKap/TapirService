package com.tkapkaev.model.error

import cats.syntax.either._
import cats.syntax.functor._
import io.circe.{Codec, Decoder, Encoder}
import sttp.tapir.{Schema, Validator}
sealed trait ErrorCode {
  def value: String
}

case object BadRequest    extends ErrorCode { override val value: String = "badRequest"    }
case object InternalError extends ErrorCode { override val value: String = "internalError" }
case object Forbidden     extends ErrorCode { override val value: String = "forbidden"     }
case object Unauthorized  extends ErrorCode { override val value: String = "unauthorized"  }
case object NotFound      extends ErrorCode { override val value: String = "notFound"      }

object ErrorCode {
  implicit val jsonCodec: Codec[ErrorCode] = Codec
    .from(Decoder[String], Encoder[String])
    .iemap {
      case "badRequest"    => BadRequest.asRight[String].widen[ErrorCode]
      case "internalError" => InternalError.asRight[String].widen[ErrorCode]
      case "forbidden"     => Forbidden.asRight[String].widen[ErrorCode]
      case "unauthorized"  => Unauthorized.asRight[String].widen[ErrorCode]
      case "notFound"      => NotFound.asRight[String].widen[ErrorCode]
    }(_.value)

  implicit val schema: Schema[ErrorCode] = Schema.schemaForString
    .validate(
      Validator.enumeration(
        List(BadRequest.value, InternalError.value, Forbidden.value, Unauthorized.value, NotFound.value)
      )
    )
    .as
}
