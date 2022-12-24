package com.tkapkaev.model.file

import com.tkapkaev.model.file.wrapping.{FileName, FilePath}

sealed trait FileOperation

case class AddFile(
    name: FileName,
    path: Option[FilePath]
) extends FileOperation
