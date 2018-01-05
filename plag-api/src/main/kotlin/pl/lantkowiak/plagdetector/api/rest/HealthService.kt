package pl.lantkowiak.plagdetector.api.rest

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthService {
    @RequestMapping("/greeting", method = [RequestMethod.GET])
    fun findAll(): String {
        return "OK"
    }
}

data class Greeting(val id: Long, val content: String)