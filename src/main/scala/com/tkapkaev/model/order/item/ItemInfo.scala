package com.tkapkaev.model.order.item

import com.tkapkaev.model.order.item.wrapping._
import com.tkapkaev.model.order.price.wrapping.Price

case class ItemInfo(
    id: ItemId,
    name: ItemName,
    category: ItemCategory,
    price: Price
)
