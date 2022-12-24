package com.tkapkaev.model.order

import com.tkapkaev.model.order.comment.Comment
import com.tkapkaev.model.order.customer.Customer
import com.tkapkaev.model.order.item.Item
import com.tkapkaev.model.user.user.Login
import io.estatico.newtype.macros.newtype

import java.util.UUID

object order {
  case class Order(
      id: OrderId,
      items: List[Item],
      status: OrderStatus,
      customer: Customer,
      creator: Login,
      comments: List[Comment],
      metaInfo: MetaInfo
  )

  @newtype
  case class OrderId(
      value: UUID
  )

}
