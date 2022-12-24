package com.tkapkaev.config

import derevo.derive
import derevo.pureconfig.config

import ConfigHint._

@derive(config)
case class Config(
    server: ServerConfig,
    app: AppConfig,
    general: GeneralConfig
)
