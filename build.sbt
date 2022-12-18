ThisBuild / version           := "0.1.0-SNAPSHOT"
ThisBuild / organization      := "com.tkapkaev"
ThisBuild / scalaVersion      := "2.13.10"
ThisBuild / semanticdbEnabled := true
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
val commonLibraries = Seq(
  "org.typelevel"                 %% "cats-core"              % catsV,
  "org.typelevel"                 %% "cats-effect"            % catsEffectV,
  "com.github.cb372"              %% "cats-retry"             % catsRetryV,
  "eu.timepit"                    %% "refined"                % refinedTypeV,
  "eu.timepit"                    %% "refined-cats"           % refinedTypeV,
  "eu.timepit"                    %% "refined-pureconfig"     % refinedTypeV,
  "io.estatico"                   %% "newtype"                % newTypeV,
  "tf.tofu"                       %% "derevo-core"            % derevoV,
  "tf.tofu"                       %% "derevo-cats"            % derevoV,
  "tf.tofu"                       %% "derevo-pureconfig"      % derevoV,
  "com.softwaremill.sttp.tapir"   %% "tapir-core"             % tapirV,
  "com.softwaremill.sttp.tapir"   %% "tapir-http4s-server"    % tapirV,
  "com.softwaremill.sttp.tapir"   %% "tapir-sttp-client"      % tapirV,
  "com.softwaremill.sttp.tapir"   %% "tapir-refined"          % tapirV,
  "com.softwaremill.sttp.tapir"   %% "tapir-derevo"           % tapirV,
  "org.typelevel"                 %% "log4cats-core"          % logsV,
  "org.typelevel"                 %% "log4cats-slf4j"         % logsV,
  "com.github.pureconfig"         %% "pureconfig"             % pureConfigV,
  "com.github.pureconfig"         %% "pureconfig-cats-effect" % pureConfigV,
  "com.github.pureconfig"         %% "pureconfig-cats"        % pureConfigV,
  "com.github.pureconfig"         %% "pureconfig-circe"       % pureConfigV,
  "io.circe"                      %% "circe-core"             % circeV,
  "io.circe"                      %% "circe-generic"          % circeV,
  "io.circe"                      %% "circe-parser"           % circeV,
  "io.circe"                      %% "circe-refined"          % circeV,
  "org.http4s"                    %% "http4s-ember-server"    % http4sV,
  "com.softwaremill.sttp.client3" %% "core"                   % sttpV,
  "com.softwaremill.sttp.client3" %% "fs2"                    % sttpV
//    "tf.tofu"                       %% "derevo-circe"           % derevoV
)

lazy val root = (project in file("."))
  .settings(
    name := "TapirService",
    libraryDependencies ++= commonLibraries
  )
