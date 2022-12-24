package com.tkapkaev.config
import com.comcast.ip4s._
import derevo.derive
import derevo.pureconfig.config
import pureconfig.module.ip4s._

import ConfigHint._

@derive(config)
case class ServerConfig(
    host: Hostname,
    port: Port
)
