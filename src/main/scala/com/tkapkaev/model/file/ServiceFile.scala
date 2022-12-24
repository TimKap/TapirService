package com.tkapkaev.model.file

import com.tkapkaev.model.file.wrapping._
import com.tkapkaev.model.order.metainfo.MetaInfo

case class ServiceFile(
    id: FileId,
    status: FileStatus,
    name: FileName,
    kind: FileKind,
    localPath: Option[FilePath],
    link: Option[FileLink],
    size: FileSize,
    md5: Option[MD5],
    extension: FileExtension,
    metaInfo: MetaInfo
)
