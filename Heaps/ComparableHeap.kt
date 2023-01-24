package DataStructures_and_Algorithms.Heaps

import DataStructures_and_Algorithms.Heaps.AbstractHeap

class ComparableHeap<Element : Comparable<Element>>() :
AbstractHeap<Element>() {

    override fun compare(a: Element, b: Element): 
        Int = a.compareTo(b)

    companion object {
        fun <Element: Comparable<Element>> create(
            elements: ArrayList<Element>
        ): Heap<Element> {
            val heap = ComparableHeap<Element>()
            heap.heapify(elements)
            return heap
        }
    }
}
