package com.tkapkaev.model

import cats.syntax.either._
import io.circe.{Codec, Decoder, Encoder}
import sttp.tapir.Schema
package object error {

  implicit val jsonThrowable: Codec[Throwable] =
    Codec
      .from(Decoder[String], Encoder[String])
      .iemap {
        new Throwable(_).asRight[String]
      }(_.getMessage)

  implicit val schemaThrowable: Schema[Throwable] = Schema.schemaForString.as
}
