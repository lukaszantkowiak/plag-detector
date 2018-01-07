package pl.lantkowiak.plagdetector.algorithm.tokenizer

import org.antlr.v4.runtime.CharStreams
import pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer.LexerFactory
import pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer.LexerType

class Tokenizer {
    fun tokenize(lexerType: LexerType, input: String): List<Int> {
        val lexer = LexerFactory.getLexer(lexerType, CharStreams.fromString(input))

        return lexer.allTokens.map { t -> t.type }
    }
}