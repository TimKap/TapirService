package com.tkapkaev.model.order.item

import eu.timepit.refined.types.string.NonEmptyString
import io.circe.Json
import io.estatico.newtype.macros.newtype

import java.util.UUID

object wrapping {
  @newtype
  case class ItemId(
      value: UUID
  )

  @newtype
  case class ItemParameters(
      value: Json
  )

  @newtype
  case class ItemName(
      value: NonEmptyString
  )

  case class ItemCategory(
      id: CategoryId,
      name: CategoryName
  )

  @newtype
  case class CategoryId(
      value: UUID
  )

  @newtype
  case class CategoryName(value: NonEmptyString)

}
