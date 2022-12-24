package com.tkapkaev.model.file

sealed trait FileKind {
  def value: String
}

case object OrderFile extends FileKind {
  override def value: String = "order"
}
