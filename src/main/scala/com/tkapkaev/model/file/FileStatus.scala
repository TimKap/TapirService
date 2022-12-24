package com.tkapkaev.model.file
sealed trait FileStatus {
  def value: String
}

case object NewStatus extends FileStatus {
  override def value: String = "new"
}

case object Uploaded extends FileStatus {
  override def value: String = "uploaded"
}

case object Deleted extends FileStatus {
  override def value: String = "deleted"
}
