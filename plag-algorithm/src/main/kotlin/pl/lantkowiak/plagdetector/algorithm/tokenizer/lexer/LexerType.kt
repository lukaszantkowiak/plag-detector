package pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer

enum class LexerType(val title: String) {
    JAVA_8("Java 8"),
    C("C"),
    CPP("C++"),
    KOTLIN("Kotlin"),
    PASCAL("Pascal"),
    PHP("PHP");

    companion object {
        fun getByTitle(title: String): LexerType {
            return LexerType.values().find { it.title == title }
                    ?: throw IllegalArgumentException("Unknown lang")
        }
    }
}