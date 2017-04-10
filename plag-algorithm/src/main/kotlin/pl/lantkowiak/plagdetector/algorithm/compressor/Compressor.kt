package pl.lantkowiak.plagdetector.algorithm.compressor

class Compressor<T> {
    fun encode(input: List<T>): List<CodedTriple<T>> {
        val coded = mutableListOf<CodedTriple<T>>()
        coded.add(CodedTriple(0, 0, input[0]))

        var i = 1;
        while (i < input.size) {
            val dictionary = this.getDictionary(i, input)
            val codedTriple = this.findLongestPrefix(i, input, dictionary)
            coded.add(codedTriple)
            i += codedTriple.length + 1
        }

        return coded
    }


    private fun getDictionary(index: Int, input: List<T>): List<T> {
        return input.subList(0, index)
    }

    private fun findLongestPrefix(position: Int, input: List<T>, dictionary: List<T>): CodedTriple<T> {
        var i = position + 1
        var last = ShiftLength(0, 0)
        var positionLength = this.findSequence(input.subList(position, i), dictionary)

        while (i < input.size && positionLength.shift > 0) {
            i++
            last = positionLength
            positionLength = this.findSequence(input.subList(position, i), dictionary)
        }
        return CodedTriple(last.shift, last.length, input[position + last.length])
    }

    // naive algorithm is used it is slow...
    private fun findSequence(sequence: List<T>, dictionary: List<T>): ShiftLength {
        var found = false

        for (i in 0 until dictionary.size) {
            for (j in 0 until sequence.size) {
                if (sequence[j] != (this.getDictionaryElement(i + j, dictionary))) {
                    found = false
                    break
                } else {
                    found = true
                }
            }
            if (found) {
                return ShiftLength(dictionary.size - i, sequence.size)
            }
        }

        return ShiftLength(0, 0)
    }


    private fun getDictionaryElement(position: Int, dictionary: List<T>): T {
        return dictionary[position % dictionary.size]
    }

    data class ShiftLength(val shift: Int, val length: Int)
}