ThisBuild / version           := "0.1.0-SNAPSHOT"
ThisBuild / organization      := "com.tkapkaev"
ThisBuild / scalaVersion      := "2.13.10"
ThisBuild / semanticdbEnabled := true
ThisBuild / scalafmtOnCompile := true
tpolecatScalacOptions ++= Set(
  ScalacOptions.privateOption("macro-annotations")
)
//ThisBuild / scalafixOnCompile := true
ThisBuild / scalafixDependencies ++= Seq(
  "com.github.liancheng" %% "organize-imports" % "0.6.0"
)
val catsV        = "2.9.0"
val catsEffectV  = "3.4.2"
val catsRetryV   = "3.1.0"
val tapirV       = "1.2.4"
val logsV        = "2.5.0"
val pureConfigV  = "0.17.2"
val circeV       = "0.14.3"
val refinedTypeV = "0.10.1"
val newTypeV     = "0.4.4"
val derevoV      = "0.13.0"
val http4sV      = "0.23.16"
val sttpV        = "3.8.5"
val logbackV     = "1.2.3"
val cron4sV      = "0.7.2"
val squantsV     = "1.6.0"
val scalaJwtV = "9.1.2"

val commonLibraries = Seq(
  // cats - library that provide abstraction for functional programming
  "org.typelevel" %% "cats-core" % catsV,
  // cats-effect - library that provides IO effect and async runtime environment for IO. Fibers
  "org.typelevel" %% "cats-effect" % catsEffectV,
  // squants - data types and a domain specific language (DSL) for representing Quantities, their Units of Measure, and their Dimensional relationships
  "org.typelevel" %% "squants" % squantsV,
  // logger
  "org.typelevel" %% "log4cats-core"   % logsV,
  "org.typelevel" %% "log4cats-slf4j"  % logsV,
  "ch.qos.logback" % "logback-classic" % logbackV,
  // cats retry
  "com.github.cb372" %% "cats-retry" % catsRetryV,
  // refined - allows construct types for improve checks
  "eu.timepit" %% "refined"            % refinedTypeV,
  "eu.timepit" %% "refined-cats"       % refinedTypeV,
  "eu.timepit" %% "refined-pureconfig" % refinedTypeV,
  // schedule task base on fs2
  "eu.timepit" %% "fs2-cron-cron4s" % cron4sV,
  // newtype - value wrapping, to improve type
  "io.estatico" %% "newtype" % newTypeV,
  // derevo - type class generation
  "tf.tofu" %% "derevo-core"       % derevoV,
  "tf.tofu" %% "derevo-cats"       % derevoV,
  "tf.tofu" %% "derevo-pureconfig" % derevoV,
  // tapir - build endpoint description (security, request, response, error)
  "com.softwaremill.sttp.tapir" %% "tapir-core"          % tapirV,
  "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % tapirV,
  "com.softwaremill.sttp.tapir" %% "tapir-sttp-client"   % tapirV,
  "com.softwaremill.sttp.tapir" %% "tapir-refined"       % tapirV,
  "com.softwaremill.sttp.tapir" %% "tapir-derevo"        % tapirV,
  "com.softwaremill.sttp.tapir" %% "tapir-json-circe"    % tapirV,
  // pureconfig - service configuration
  "com.github.pureconfig" %% "pureconfig"             % pureConfigV,
  "com.github.pureconfig" %% "pureconfig-cats-effect" % pureConfigV,
  "com.github.pureconfig" %% "pureconfig-cats"        % pureConfigV,
  "com.github.pureconfig" %% "pureconfig-circe"       % pureConfigV,
  "com.github.pureconfig" %% "pureconfig-ip4s"        % pureConfigV,
  //jwt - scala-jwt
  "com.github.jwt-scala" %% "jwt-circe" % scalaJwtV,
  // circe - working with json
  "io.circe" %% "circe-core"    % circeV,
  "io.circe" %% "circe-generic" % circeV,
  "io.circe" %% "circe-parser"  % circeV,
  "io.circe" %% "circe-refined" % circeV,
  // ember - http4s server implementation
  "org.http4s" %% "http4s-ember-server" % http4sV,
  // sttp-client - http client
  "com.softwaremill.sttp.client3" %% "core" % sttpV,
  "com.softwaremill.sttp.client3" %% "fs2"  % sttpV,

  //    "tf.tofu"                       %% "derevo-circe"           % derevoV,
  "com.github.eikek" %% "emil-common"   % "0.13.0",
  "com.github.eikek" %% "emil-javamail" % "0.13.0"
)

lazy val root = (project in file("."))
  .settings(
    name := "oms",
    libraryDependencies ++= commonLibraries
  )
