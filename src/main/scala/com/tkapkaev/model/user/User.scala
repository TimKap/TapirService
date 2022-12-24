package com.tkapkaev.model.user

import com.tkapkaev.model.user.role.Role
import com.tkapkaev.model.user.wrapping._

case class User(
    id: UserId,
    login: Login,
    token: Token,
    roles: List[Role]
)
