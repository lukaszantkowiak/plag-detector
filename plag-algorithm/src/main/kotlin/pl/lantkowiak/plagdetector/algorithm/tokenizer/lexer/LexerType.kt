package pl.lantkowiak.plagdetector.algorithm.tokenizer.lexer

enum class LexerType(val title: String) {
    JAVA_8("Java 8");

    companion object {
        fun getByTitle(title: String): LexerType {
            return LexerType.values().find { it.title == title }
                    ?: throw IllegalArgumentException("Unknown lang")
        }
    }
}