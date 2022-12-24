package com.tkapkaev.model.order

import io.estatico.newtype.macros.newtype
import squants.market.Money

object price {
  @newtype
  case class Price(value: Money)
}
