package pl.lantkowiak.plagdetector.api.rest

data class PlagCalculationEntity(
        val lang: String = "",
        val code1: String = "",
        val code2: String = "")