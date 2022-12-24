package com.tkapkaev.model
package order

import com.tkapkaev.model.user.user.Login

import java.time.Instant

case class MetaInfo(
    creator: Login,
    creationDate: Instant,
    lastEditor: Login,
    lastEditionDate: Instant
)
