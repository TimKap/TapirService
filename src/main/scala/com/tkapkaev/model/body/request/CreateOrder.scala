package com.tkapkaev.model.body.request

import com.tkapkaev.model.file.AddFile
import com.tkapkaev.model.order.comment.AddComment
import com.tkapkaev.model.order.customer.wrapping._
import com.tkapkaev.model.order.position.AddPosition

case class CreateOrder(
    positions: List[AddPosition],
    customer: CustomerId,
    comment: AddComment,
    files: List[AddFile]
)
