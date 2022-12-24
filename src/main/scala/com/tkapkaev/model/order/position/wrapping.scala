package com.tkapkaev.model.order.position

import io.estatico.newtype.macros.newtype

import java.util.UUID

object wrapping {
  @newtype
  case class PositionId(
      value: UUID
  )
}
