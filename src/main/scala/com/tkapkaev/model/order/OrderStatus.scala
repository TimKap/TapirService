package com.tkapkaev.model.order

sealed trait OrderStatus {
  def value: String
}

case object NewStatus extends OrderStatus {
  override def value: String = "New"
}

case object Processing extends OrderStatus {
  override def value: String = "Processing"
}

case object WaitingForPayment extends OrderStatus {
  override def value: String = "WaitingForPayment"
}

case object Paid extends OrderStatus {
  override def value: String = "Paid"
}

case object SentForDelivery extends OrderStatus {
  override def value: String = "SentForDelivery"
}

case object DeliveryInProgress extends OrderStatus {
  override def value: String = "DeliveryInProgress"
}

case object Delivered extends OrderStatus {
  override def value: String = "Delivered"
}

case class UnknownStatus(override val value: String) extends OrderStatus
