package com.tkapkaev.model.order

import eu.timepit.refined.numeric.NonNegative
import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype

import java.util.UUID

object file {

  case class ServiceFile(
      id: FileId,
      name: FileName,
      path: FilePath,
      size: FileSize,
      extension: FileExtension,
      content: Array[Byte],
      metaInfo: MetaInfo
  )

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

}
