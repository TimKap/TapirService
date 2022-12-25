package com.tkapkaev.model.order

import java.util.UUID

import io.estatico.newtype.macros.newtype

object wrapping {

  @newtype
  case class OrderId(
      value: UUID
  )

}
