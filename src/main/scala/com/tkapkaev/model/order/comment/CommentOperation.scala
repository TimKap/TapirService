package com.tkapkaev.model.order.comment

import com.tkapkaev.model.file.wrapping.FileId
import com.tkapkaev.model.order.comment.wrapping.CommentContent

sealed trait CommentOperation
case class AddComment(
    content: CommentContent,
    files: List[FileId]
) extends CommentOperation
