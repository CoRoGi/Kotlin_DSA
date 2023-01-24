package DataStructures_and_Algorithms.Sorts

import DataStructures_and_Algorithms.Sorts.swapAt

fun<T: Comparable<T>> MutableList<T>.partitionDutchFlag(
    low: Int,
    high: Int,
    pivotIndex: Int): Pair<Int, Int> {

    val pivot = this[pivotIndex]
    var smaller = low
    var equal = low
    var larger = high

    while (equal <= larger) {

        if (this[equal] < pivot) {

            this.swapAt(smaller, equal)
            smaller += 1
            equal += 1

        } else if (this[equal] == pivot) {

            equal += 1

        } else {

            this.swapAt(equal, larger)
            larger -= 1

        }

    }

    return Pair(smaller, larger)

}

fun<T: Comparable<T>> MutableList<T>.quicksortDutchFlag(
    low: Int,
    high: Int) {

    if (low < high) {

        val middle = partitionDutchFlag(low, high, high)
        this.quicksortDutchFlag(low, middle.first - 1)
        this.quicksortDutchFlag(middle.second + 1, high)

    }

}
