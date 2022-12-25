package com.tkapkaev.model.user.role

import com.tkapkaev.derevo.jsonCodec
import com.tkapkaev.model.user.role.wrapping._
import derevo.derive

@derive(jsonCodec)
case class Attribute(
    id: AttributeId,
    name: AttributeName
)
