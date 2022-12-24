package com.tkapkaev.model.order

import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype

import java.util.UUID

object customer {

  case class Customer(
      id: CustomerId,
      name: CustomerName
  )

  @newtype
  case class CustomerId(
      value: UUID
  )

  @newtype
  case class CustomerName(value: NonEmptyString)
}
