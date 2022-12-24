package com.tkapkaev.model.order.customer

import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype

import java.util.UUID

object wrapping {

  @newtype
  case class CustomerId(
      value: UUID
  )

  @newtype
  case class CustomerName(value: NonEmptyString)

}
