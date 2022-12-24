package com.tkapkaev.model.order.price

import io.estatico.newtype.macros.newtype
import squants.market.Money

object wrapping {
  @newtype
  case class Price(value: Money)
}
