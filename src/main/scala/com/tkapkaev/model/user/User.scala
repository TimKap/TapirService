package com.tkapkaev.model.user

import com.tkapkaev.model.user.role.Attribute
import com.tkapkaev.model.user.wrapping._

case class User(
    id: UserId,
    login: Login,
    token: JwtToken,
    attributes: List[Attribute]
)
