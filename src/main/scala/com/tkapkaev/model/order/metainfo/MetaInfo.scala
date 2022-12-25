package com.tkapkaev.model.order.metainfo

import java.time.Instant

import com.tkapkaev.model.user.wrapping.Login

case class MetaInfo(
    creator: Login,
    creationDate: Instant,
    lastEditor: Login,
    lastEditionDate: Instant
)
