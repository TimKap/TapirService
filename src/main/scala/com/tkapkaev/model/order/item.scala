package com.tkapkaev.model.order
import com.tkapkaev.model.order.file.ServiceFile
import com.tkapkaev.model.order.price.Price
import eu.timepit.refined.types.string.NonEmptyString
import io.circe.Json
import io.estatico.newtype.macros.newtype

import java.util.UUID

object item {

  sealed trait Item {
    def id: ItemId
    def name: ItemName
    def category: ItemCategory
    def price: Price
    def files: List[ServiceFile]
    def metaInfo: MetaInfo
  }

  case class GeneralItem(
      id: ItemId,
      name: ItemName,
      category: ItemCategory,
      price: Price,
      files: List[ServiceFile],
      metaInfo: MetaInfo,
      parameters: ItemParameters
  ) extends Item

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
