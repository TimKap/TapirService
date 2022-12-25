package com.tkapkaev.model.user

import com.tkapkaev.derevo._
import derevo.derive

import java.util.UUID
import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype
import io.circe.refined._
object wrapping {

  @derive(jsonEncoder, jsonDecoder)
  @newtype
  case class UserId(
      value: UUID
  )

  @derive(jsonEncoder, jsonDecoder)
  @newtype
  case class JwtToken(
      value: String
  )

  @derive(jsonEncoder, jsonDecoder)
  @newtype
  case class Login(
      value: NonEmptyString
  )

}
