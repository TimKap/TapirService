package com.tkapkaev.model.order

import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype

import java.util.UUID

object comment {

  case class Comment(
      id: CommentId,
      text: NonEmptyString,
      metaInfo: MetaInfo
  )

  @newtype
  case class CommentId(value: UUID)
}
