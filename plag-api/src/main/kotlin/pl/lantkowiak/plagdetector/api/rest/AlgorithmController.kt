package pl.lantkowiak.plagdetector.api.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import pl.lantkowiak.plagdetector.algorithm.kolmogorov.KolmogorovCalculationResult
import pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer.LexerType
import pl.lantkowiak.plagdetector.api.service.AlgorithmService


@RestController
@RequestMapping("algorithms", produces = [MediaType.APPLICATION_JSON_VALUE])
class AlgorithmController {
    @Autowired
    private lateinit var algorithmService: AlgorithmService


    @RequestMapping("/languages", method = [RequestMethod.GET])
    fun getLanguages(): ResponseEntity<List<String>>? {
        val langs = LexerType.values().map { it.title }
        return ResponseEntity.ok(langs)
    }

    @RequestMapping("/calculate", method = [RequestMethod.POST])
    fun calculateProbability(@RequestBody plagCalculationEntity: PlagCalculationEntity): ResponseEntity<KolmogorovCalculationResult>? {
        val result = algorithmService.calculateSimilarity(plagCalculationEntity.lang, plagCalculationEntity.code1, plagCalculationEntity.code2)

        return ResponseEntity.ok(result)
    }
}