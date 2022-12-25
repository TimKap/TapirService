package com.tkapkaev.model.error

import com.tkapkaev.derevo.jsonCodec
import derevo.derive
import eu.timepit.refined.types.string.NonEmptyString
import io.circe.refined._
import sttp.tapir.codec.refined._
import sttp.tapir.derevo.schema

@derive(jsonCodec, schema)
case class ServiceError(
    code: ErrorCode,
    message: NonEmptyString,
    error: Option[Throwable]
)
