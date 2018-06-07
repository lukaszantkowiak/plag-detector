package pl.lantkowiak.plagdetector.api.service

import pl.lantkowiak.plagdetector.algorithm.PlagDetectorAlgorithm
import pl.lantkowiak.plagdetector.algorithm.kolmogorov.KolmogorovCalculationResult
import pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer.LexerType
import javax.inject.Named

@Named
class AlgorithmService {
    fun calculateSimilarity(lang: String, code1: String, code2: String): KolmogorovCalculationResult {
        val lexerType = LexerType.getByTitle(lang)

        return PlagDetectorAlgorithm().calculate(lexerType, code1, code2)
    }
}