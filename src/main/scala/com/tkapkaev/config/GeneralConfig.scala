package com.tkapkaev.config

import com.tkapkaev.endpoint.auth.wrapping.PublicKey
import derevo.derive
import derevo.pureconfig.config

import ConfigHint._

@derive(config)
case class GeneralConfig(
    serviceName: String,
    version: String,
    jwtPublicKey: PublicKey
)
