package DataStructures_and_Algorithms.Queues

import DataStructures_and_Algorithms.Heaps.Heap
import DataStructures_and_Algorithms.Queues.Queue

abstract class AbstractPriorityQueue<T> : Queue<T> {

    abstract val heap: Heap<T>
        get

    override fun enqueue(element: T): Boolean {

        heap.insert(element)
        return true

    }

    override fun dequeue() = heap.remove()

    override val count: Int
        get() = heap.count

    override fun peek() = heap.peek()

}
