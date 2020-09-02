package ir.adicom.app.beginneridea

class StringCalculator {
    fun add(numbers: String): Int {
        if (numbers.trim().isEmpty()) return 0
        val newNumbers = numbers.replace("\n", ",")
        val list: List<String> = newNumbers.split(",")
        var result = 0
        for (num in list) {
            result += num.toInt()
        }
        return result
    }
}