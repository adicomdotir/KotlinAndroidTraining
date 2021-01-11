package ir.adicom.app.beginneridea

class PrimeNumbers {
    fun generate(n: Int): List<Int> {
        val mutableList = mutableListOf<Int>()
        var mutableValue = n
        var counter = 2
        while (mutableValue > 1) {
            while (mutableValue % counter == 0) {
                mutableList.add(counter)
                mutableValue /= counter
            }
            counter++
        }
        return mutableList
    }
}