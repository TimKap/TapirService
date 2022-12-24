package com.tkapkaev.model.order.item

import com.tkapkaev.model.file.ServiceFile
import com.tkapkaev.model.order.item.wrapping._
import com.tkapkaev.model.order.metainfo.MetaInfo
import com.tkapkaev.model.order.price.wrapping.Price

sealed trait Item {
  def id: ItemId

  def name: ItemName

  def category: ItemCategory

  def price: Price

  def files: List[ServiceFile]

  def metaInfo: MetaInfo
}

case class GeneralItem(
    id: ItemId,
    name: ItemName,
    category: ItemCategory,
    price: Price,
    files: List[ServiceFile],
    metaInfo: MetaInfo,
    parameters: ItemParameters
) extends Item
