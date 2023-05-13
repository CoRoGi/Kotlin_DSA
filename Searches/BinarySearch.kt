package DataStructures_and_Algorithms.Searches

/* binary search is a method which can be performed on arraylists populates bt any type which can be compared. the value argument is the value which is being searched for in the array, and its index will be returned if found, with null being returned otherwise. The range argument corresponds to ArrayList.indices of the array on which this operation is being performed. */
fun <T: Comparable<T>> ArrayList<T>.binarySearch(
    value: T,
    range: IntRange = indices
) : Int? {
    
    /* Base condition */
    if (range.first > range.last) {
        return null
    }
    
    /* get the size of the array */
    val size = range.last - range.first + 1
    
    /* get the middle index */
    val middle = range.first + size / 2

    return when {

        this[middle] == value -> middle

        this[middle] > value ->
            binarySearch(value, range.first until middle)

        else -> binarySearch(value, (middle + 1)..range.last)

    }
}
