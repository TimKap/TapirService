package com.tkapkaev.model.order

import com.tkapkaev.model.file.ServiceFile
import com.tkapkaev.model.order.comment.Comment
import com.tkapkaev.model.order.customer.Customer
import com.tkapkaev.model.order.metainfo.MetaInfo
import com.tkapkaev.model.order.position.Position
import com.tkapkaev.model.order.wrapping.OrderId

case class Order(
    id: OrderId,
    positions: List[Position],
    status: OrderStatus,
    customer: Customer,
    comments: List[Comment],
    files: List[ServiceFile],
    metaInfo: MetaInfo
)
