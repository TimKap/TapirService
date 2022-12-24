package com.tkapkaev.config

import pureconfig.generic.ProductHint
import pureconfig.{CamelCase, ConfigFieldMapping}

object ConfigHint {
  implicit def hint[A]: ProductHint[A] = ProductHint[A](ConfigFieldMapping(CamelCase, CamelCase))
}
