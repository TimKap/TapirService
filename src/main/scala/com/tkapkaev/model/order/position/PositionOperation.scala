package com.tkapkaev.model.order.position

import com.tkapkaev.model.order.item.wrapping.ItemId
import eu.timepit.refined.numeric.NonNegative

sealed trait PositionOperation

case class AddPosition(
    itemId: ItemId,
    count: NonNegative
) extends PositionOperation
