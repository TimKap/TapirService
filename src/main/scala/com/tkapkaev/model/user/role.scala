package com.tkapkaev.model.user

import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype

import java.util.UUID

object role {
  case class Role(
      id: RoleId,
      name: RoleName
  )

  @newtype
  case class RoleId(
      value: UUID
  )

  @newtype
  case class RoleName(
      value: NonEmptyString
  )

}
