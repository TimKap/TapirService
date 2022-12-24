package com.tkapkaev.model.order.comment

import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype

import java.util.UUID

object wrapping {

  @newtype
  case class CommentId(value: UUID)

  @newtype
  case class CommentContent(value: NonEmptyString)
}
