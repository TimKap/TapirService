package com.tkapkaev.model.order.metainfo

import com.tkapkaev.model.user.wrapping.Login

import java.time.Instant

case class MetaInfo(
    creator: Login,
    creationDate: Instant,
    lastEditor: Login,
    lastEditionDate: Instant
)
