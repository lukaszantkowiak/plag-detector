package pl.lantkowiak.plagdetector.algorithm.kolmogorov

class KolmogorovCalculator {
    fun calculate(encodedData1Size: Int, encodedData2Size: Int, encodedData1_2Size: Int): KolmogorovCalculationResult {
        val d = calculateD(encodedData1Size, encodedData2Size, encodedData1_2Size)

        val px = calculateP(d, encodedData1Size, encodedData2Size)
        val py = calculateP(d, encodedData2Size, encodedData1Size)

        return KolmogorovCalculationResult(d, px, py)
    }

    private fun calculateD(encodedData1Size: Int, encodedData2Size: Int, encodedData1_2Size: Int): Double {
        return (encodedData1Size + encodedData2Size - encodedData1_2Size) / (1.0 * encodedData1_2Size)
    }

    private fun calculateP(d: Double, size1: Int, size2: Int): Double {
        val a = size2 / (1.0 * size1)

        return d * (a + 1) / (d + 1.0)
    }
}