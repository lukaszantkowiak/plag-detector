package pl.lantkowiak.plagdetector.algorithm.compressor;

data class CodedTriple<T>(val shift: Int, val length: Int, val next: T)