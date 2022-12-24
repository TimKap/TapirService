package com.tkapkaev.model.order

import eu.timepit.refined.types.string.NonEmptyString
import eu.timepit.refined.auto._

sealed trait OrderStatus {
  def value: NonEmptyString
}

case object NewStatus extends OrderStatus {
  override def value: NonEmptyString = "New"
}

case object Processing extends OrderStatus {
  override def value: NonEmptyString = "Processing"
}

case object WaitingForPayment extends OrderStatus {
  override def value: NonEmptyString = "WaitingForPayment"
}

case object Paid extends OrderStatus {
  override def value: NonEmptyString = "Paid"
}

case object SentForDelivery extends OrderStatus {
  override def value: NonEmptyString = "SentForDelivery"
}

case object DeliveryInProgress extends OrderStatus {
  override def value: NonEmptyString = "DeliveryInProgress"
}

case object Delivered extends OrderStatus {
  override def value: NonEmptyString = "Delivered"
}

case class UnknownStatus(override val value: NonEmptyString) extends OrderStatus
