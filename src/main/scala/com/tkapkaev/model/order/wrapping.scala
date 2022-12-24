package com.tkapkaev.model.order

import io.estatico.newtype.macros.newtype

import java.util.UUID

object wrapping {

  @newtype
  case class OrderId(
      value: UUID
  )

}
