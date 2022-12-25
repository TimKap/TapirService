package com.tkapkaev.endpoint.auth

import derevo.derive
import derevo.pureconfig.config
import io.estatico.newtype.macros.newtype

object wrapping {

  @derive(config)
  @newtype
  case class PublicKey(value: String)
}
