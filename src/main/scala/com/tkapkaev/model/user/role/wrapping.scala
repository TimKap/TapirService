package com.tkapkaev.model.user.role

import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype

import java.util.UUID

object wrapping {

  @newtype
  case class RoleId(
      value: UUID
  )

  @newtype
  case class RoleName(
      value: NonEmptyString
  )

}
