package DataStructures_and_Algorithms.Queues

import DataStructures_and_Algorithms.Queues.AbstractPriorityQueue
import DataStructures_and_Algorithms.Heaps.ComparatorHeap

class ComparatorPriorityQueue<T>(
    private val comparator: Comparator<T>
    ): AbstractPriorityQueue<T>() {

        override val heap = ComparatorHeap(comparator)

    }
