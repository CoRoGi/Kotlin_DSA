package DataStructures_and_Algorithms.Heaps

import java.util.*
import DataStructures_and_Algorithms.Heaps.Heap

abstract class AbstractHeap<Element>() : Heap<Element> {

    abstract fun compare(a: Element, b: Element): Int 
    
    var elements: ArrayList<Element> = ArrayList<Element>()

    override val count: Int
        get() = elements.size

    override fun peek(): Element? = elements.first()

    private fun leftChildIndex(index: Int) = (2 * index) + 1

    private fun rightChildIndex(index: Int) = (2 * index) + 2

    private fun parentIndex(index: Int) = (index - 1) / 2

    // O(log n)
    override fun insert(element: Element) {
        
        //O(1)
        elements.add(element)

        //O(log n)
        siftUp(count - 1)

    }

    private fun siftUp(index: Int) {
        
        var child = index
        var parent = parentIndex(child)

        while (child > 0 && compare(elements[child],
            elements[parent]) > 0) {
            
            elements.forEach {

                element -> print("${element}, ")

            }

            println("")
            Collections.swap(elements, child, parent)
            child = parent
            parent = parentIndex(child)


            elements.forEach {

                element -> print("${element}, ")

            }

            println("")

        } 

    }

    override fun remove(): Element? {

        if (isEmpty) return null

        Collections.swap(elements, 0, count - 1)
        val item = elements.removeAt(count - 1)
        siftDown(0)
        return item

    }

    private fun siftDown(index: Int) {

        var parent = index

        while (true) {

            elements.forEach {

                element -> print("${element}, ")

            }

            println("")
            val left = leftChildIndex(parent)
            var right = rightChildIndex(parent)
            var candidate = parent

            if (left < count &&
                compare(elements[left], elements[candidate]) > 0) {

                candidate = left

            }

        
        
            if (right < count &&
                compare(elements[right], elements[candidate]) > 0) {

                candidate = right
                
            }

        
            if (candidate == parent) {

                return

            }
    
            Collections.swap(elements, parent, candidate)
            parent = candidate

        }

    }
    
    override fun remove(index: Int): Element? {

        if (index >= count) {

            return null
                
        }

        return if (index == count - 1) {
                
            elements.removeAt(count - 1)
                
        } else {

            Collections.swap(elements, index, count - 1)
            val item = elements.removeAt(count - 1)
            siftDown(index)
            siftUp(index)
            item

        }

    }

    private fun index(element: Element, i: Int): Int? {

        if (i >= count) {
            return null
        }
/*
        if (sort(element, elements[i])) {
            return null
        }
*/
        if (element == elements[i]) {
            return i
        }

        val leftChildIndex = index(element, leftChildIndex(i))
                
        if (leftChildIndex != null) {
            return leftChildIndex
        }

        val rightChildIndex = index(element, rightChildIndex(i))
                
        if (rightChildIndex != null) {
            return rightChildIndex
        }
        
        return null

    } 

    protected fun heapify(values: ArrayList<Element>) {
        
        elements = values
        if (!elements.isEmpty()) {
            (count / 2 downTo 0).forEach {
                siftDown(it)

            }
        }
    }
}
