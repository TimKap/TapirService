package com.tkapkaev.model.user

import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype

import java.util.UUID

object wrapping {
  @newtype
  case class UserId(
      value: UUID
  )

  @newtype
  case class Token(
      value: String
  )

  @newtype
  case class Login(
      value: NonEmptyString
  )

}
