package DataStructures_and_Algorithms.Queues

import DataStructures_and_Algorithms.Queues.Queue
import DataStructures_and_Algorithms.LinkedLists.LinkedList
import DataStructures_and_Algorithms.LinkedLists.DoublyLinkedList

class LinkedListQueue<T> : Queue<T> {

    private val list = DoublyLinkedList<T>()

    private var size = 0
    
    override val count: Int
        get() = size

    //0(1)
    override fun enqueue(element: T): Boolean {

        list.append(element)
        size++
        return true

    }

    //0(1)
    override fun dequeue(): T? {

        val firstNode = list.first ?: return null
        size--
        return list.remove(firstNode)

    }

    //0(1)
    override fun peek(): T? = list.first?.value

    override fun toString(): String = list.toString()

}
