package  DataStructures_and_Algorithms.Heaps

import DataStructures_and_Algorithms.Heaps.AbstractHeap

class ComparatorHeap<Element>(
    private val comparator: Comparator<Element>
) : AbstractHeap<Element>() {

    override fun compare(a: Element, b: Element):
        Int = comparator.compare(a, b)
        

    companion object {
        fun <Element> create(
            elements: ArrayList<Element>,
            comparator: Comparator<Element>
        ): Heap<Element> {
            val heap = ComparatorHeap(comparator)
            heap.heapify(elements)
            return heap
        }

    }
}
