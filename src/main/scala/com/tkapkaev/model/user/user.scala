package com.tkapkaev.model.user

import com.tkapkaev.model.user.role.Role
import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype

import java.util.UUID

object user {
  case class User(
      id: UserId,
      login: Login,
      token: Token,
      roles: List[Role]
  )

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
