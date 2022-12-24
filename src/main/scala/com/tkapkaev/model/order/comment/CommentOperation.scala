package com.tkapkaev.model.order.comment

import com.tkapkaev.model.order.comment.wrapping.CommentContent

sealed trait CommentOperation
case class AddComment(
    content: CommentContent
) extends CommentOperation
