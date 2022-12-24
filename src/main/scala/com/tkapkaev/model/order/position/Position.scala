package com.tkapkaev.model.order.position

import com.tkapkaev.model.order.item._
import com.tkapkaev.model.order.position.wrapping.PositionId
import com.tkapkaev.model.order.wrapping.OrderId
import eu.timepit.refined.numeric.NonNegative
case class Position(
    id: PositionId,
    orderId: OrderId,
    itemInfo: ItemInfo,
    count: NonNegative
)
