package com.tkapkaev.model.user

import com.tkapkaev.derevo.jsonCodec
import com.tkapkaev.model.user.role.Attribute
import com.tkapkaev.model.user.wrapping.{Login, UserId}
import derevo.derive

@derive(jsonCodec)
case class UserClaim(
    id: UserId,
    login: Login,
    attributes: List[Attribute]
)
