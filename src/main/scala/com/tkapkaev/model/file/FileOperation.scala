package com.tkapkaev.model.file

import com.tkapkaev.model.file.wrapping._

sealed trait FileOperation

case class AddFile(
    id: FileId,
    name: FileName,
    kind: FileKind
) extends FileOperation
