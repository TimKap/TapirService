package com.tkapkaev.config

import derevo.derive
import derevo.pureconfig.config

import ConfigHint._

@derive(config)
case class GeneralConfig(
    serviceName: String,
    version: String
)
