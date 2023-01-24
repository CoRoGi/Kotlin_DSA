package DataStructures_and_Algorithms.Queues

import DataStructures_and_Algorithms.Queues.AbstractPriorityQueue
import DataStructures_and_Algorithms.Heaps.ComparableHeap

class ComparablePriorityQueue<T: Comparable<T>> :
    AbstractPriorityQueue<T>() {

    override val heap = ComparableHeap<T>()

}
