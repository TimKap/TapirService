package com.tkapkaev.model.file

import java.util.UUID

import eu.timepit.refined.numeric.NonNegative
import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype

object wrapping {
  @newtype
  case class FileId(value: UUID)

  @newtype
  case class FileSize(value: NonNegative)

  @newtype
  case class FilePath(value: NonEmptyString)

  @newtype
  case class FileName(value: NonEmptyString)

  @newtype
  case class FileExtension(
      value: NonEmptyString
  )

  @newtype
  case class FileLink(
      value: NonEmptyString
  )

  @newtype
  case class MD5(
      value: NonEmptyString
  )

  @newtype
  case class FileStatus(
      value: NonEmptyString
  )

}
