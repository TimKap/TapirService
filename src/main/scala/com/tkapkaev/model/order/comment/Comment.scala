package com.tkapkaev.model.order.comment

import com.tkapkaev.model.order.comment.wrapping._
import com.tkapkaev.model.order.metainfo.MetaInfo

case class Comment(
    id: CommentId,
    content: CommentContent,
    metaInfo: MetaInfo
)
