package com.tkapkaev.derevo
import derevo._
import io.circe.{Codec, Decoder, Encoder}

@delegating("io.circe.generic.semiauto.deriveCodec")
object jsonCodec extends Derivation[Codec] with NewTypeDerivation[Codec] {
  def instance[A]: Codec[A] = macro Derevo.delegate[Codec, A]
}

@delegating("io.circe.generic.semiauto.deriveEncoder")
object jsonEncoder extends Derivation[Encoder] with NewTypeDerivation[Encoder] {
  def instance[A]: Encoder[A] = macro Derevo.delegate[Encoder, A]
}

@delegating("io.circe.generic.semiauto.deriveDecoder")
object jsonDecoder extends Derivation[Decoder] with NewTypeDerivation[Decoder] {
  def instance[A]: Decoder[A] = macro Derevo.delegate[Decoder, A]
}
