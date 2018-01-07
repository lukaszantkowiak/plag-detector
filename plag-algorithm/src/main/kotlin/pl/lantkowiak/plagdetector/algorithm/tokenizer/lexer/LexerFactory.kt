package pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer

import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.CharStream
import pl.lantkowiak.plagdetector.algorithm.grammar.*

class LexerFactory {
    companion object {
        fun getLexer(type: LexerType, cs: CharStream): Lexer {
            when (type) {
                LexerType.JAVA_8 -> return Java8Lexer(cs)
                LexerType.CPP -> return CPP14Lexer(cs)
                LexerType.C -> return CLexer(cs)
                LexerType.PHP -> return PhpLexer(cs)
                LexerType.KOTLIN -> return KotlinLexer(cs)
                LexerType.PASCAL -> return pascalLexer(cs)
            }
        }
    }
}