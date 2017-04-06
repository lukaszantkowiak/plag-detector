package pl.lantkowiak.plagdetector.algorithm.tokenizer

import org.antlr.v4.runtime.atn.LexerTypeAction
import pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer.LexerType

interface Tokenizer {
	fun tokenize(lexerType: LexerType, input: String): List<Int>;
}