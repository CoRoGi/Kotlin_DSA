package DataStructures_and_Algorithms.Heaps

import DataStructures_and_Algorithms.Heaps.Collection

interface Heap<Element> : Collection<Element> {

    fun peek(): Element?

}
