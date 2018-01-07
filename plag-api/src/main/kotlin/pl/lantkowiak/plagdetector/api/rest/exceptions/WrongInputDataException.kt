package pl.lantkowiak.plagdetector.api.rest.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class WrongInputDataException(message: String?) : RuntimeException(message) {
}