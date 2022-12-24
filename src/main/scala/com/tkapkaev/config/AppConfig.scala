package com.tkapkaev.config

import derevo.derive
import derevo.pureconfig.config
import eu.timepit.refined.pureconfig._
import eu.timepit.refined.types.string.NonEmptyString

import ConfigHint._
@derive(config)
case class AppConfig(
    email: NonEmptyString,
    password: NonEmptyString
)
