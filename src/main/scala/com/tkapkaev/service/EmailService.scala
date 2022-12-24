package com.tkapkaev.service

import cats.effect.Sync
import emil.MailConfig
import emil.SearchQuery._
import emil.javamail.{JavaMailEmil, Settings}

trait EmailService[F[_]] {
  def getEmail: F[String]
}

object EmailService {

  class EmailServiceImpl[F[_]: Sync](config: MailConfig, settings: Settings) extends EmailService[F] {

    private val emil     = JavaMailEmil(settings)
    private val access   = emil.access
    private val executor = emil(config)
    override def getEmail: F[String] = {

      executor.run(for {
        folder <- access.getInbox
        emails <- access.search(folder, 20)(Flagged)
      } yield emails.mails.mkString(",\r\n"))
    }
  }

  def apply[F[_]: Sync](config: MailConfig, settings: Settings = Settings.defaultSettings): EmailService[F] =
    new EmailServiceImpl[F](config, settings)

}
