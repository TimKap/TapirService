package com.tkapkaev.model.order.customer

import java.util.UUID

import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype

object wrapping {

  @newtype
  case class CustomerId(
      value: UUID
  )

  @newtype
  case class CustomerName(value: NonEmptyString)

}
