package pl.lantkowiak.plagdetector.algorithm

import pl.lantkowiak.plagdetector.algorithm.compressor.Compressor
import pl.lantkowiak.plagdetector.algorithm.kolmogorov.KolmogorovCalculationResult
import pl.lantkowiak.plagdetector.algorithm.kolmogorov.KolmogorovCalculator
import pl.lantkowiak.plagdetector.algorithm.tokenizer.Tokenizer
import pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer.LexerType


class PlagDetectorAlgorithm {
    private val tokenizer = Tokenizer()
    private val compressor = Compressor<Int>()
    private val kolmogorovCalculator = KolmogorovCalculator()

    public fun calculate(lexerType: LexerType, data1: String, data2: String): KolmogorovCalculationResult {
        val tokenizedData1 = this.tokenizer.tokenize(lexerType, data1);
        val tokenizedData2 = this.tokenizer.tokenize(lexerType, data2);
        val tokenizedData1_2 = mutableListOf<Int>();
        tokenizedData1_2.addAll(tokenizedData1);
        tokenizedData1_2.addAll(tokenizedData2);

        val encodedData1Size = this.compressor.encode(tokenizedData1).size;
        val encodedData2Size = this.compressor.encode(tokenizedData2).size;
        val encodedData1_2Size = this.compressor.encode(tokenizedData1_2).size;

        return kolmogorovCalculator.calculate(encodedData1Size, encodedData2Size, encodedData1_2Size);
    }
}