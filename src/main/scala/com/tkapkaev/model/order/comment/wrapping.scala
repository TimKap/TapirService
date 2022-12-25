package com.tkapkaev.model.order.comment

import java.util.UUID

import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype

object wrapping {

  @newtype
  case class CommentId(value: UUID)

  @newtype
  case class CommentContent(value: NonEmptyString)
}
