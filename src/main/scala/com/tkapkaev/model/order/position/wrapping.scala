package com.tkapkaev.model.order.position

import java.util.UUID

import io.estatico.newtype.macros.newtype

object wrapping {
  @newtype
  case class PositionId(
      value: UUID
  )
}
