package com.tkapkaev.endpoint

import com.tkapkaev.config.GeneralConfig
import com.tkapkaev.endpoint.auth.Auth
import com.tkapkaev.model.error._
import sttp.model.StatusCode
import sttp.tapir._
import sttp.tapir.json.circe._

trait GeneralEndpoint[F[_]] extends Auth[F] {
  def generalConfig: GeneralConfig
  def baseEndpoint(version: String) = endpoint
    .in(generalConfig.serviceName)
    .in("api" / version)
    .errorOut(
      oneOf[ServiceError](
        oneOfVariantValueMatcher(StatusCode.Unauthorized, jsonBody[ServiceError]) {
          case ServiceError(Unauthorized, _, _) =>
            true
        },
        oneOfVariantValueMatcher(StatusCode.Forbidden, jsonBody[ServiceError]) { case ServiceError(Forbidden, _, _) =>
          true
        },
        oneOfVariantValueMatcher(StatusCode.BadRequest, jsonBody[ServiceError]) { case ServiceError(BadRequest, _, _) =>
          true
        },
        oneOfVariantValueMatcher(StatusCode.NotFound, jsonBody[ServiceError]) { case ServiceError(NotFound, _, _) =>
          true
        },
        oneOfVariantValueMatcher(StatusCode.InternalServerError, jsonBody[ServiceError]) { case ServiceError(_, _, _) =>
          true
        }
      )
    )

  def authEndpoint(version: String) = baseEndpoint(version)
    .securityIn(auth.bearer[String]())
    .serverSecurityLogic(authenticate)

}
