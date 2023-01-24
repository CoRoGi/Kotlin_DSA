package DataStructures_and_Algorithms.LinkedLists

import DataStructures_and_Algorithms.LinkedLists.Node


class LinkedList<T> : 
Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set

    override fun isEmpty(): Boolean {

        return size == 0

     }


    override fun add(element: T): Boolean {
        
        append(element)
        return true

    }


    override fun addAll(elements: Collection<T>): Boolean {

        for (element in elements) { append(element) }
        
        return true

    }

    override fun clear() {

        head = null
        tail = null
        size = 0

    }

    
    override fun remove(element: T): Boolean {

        val iterator = iterator()

        while (iterator.hasNext()) {

            val item = iterator.next()

            if (item == element) {
            
                iterator.remove()
                return true
            }

        }    

        return false

    }

    override fun removeAll(elements: Collection<T>): Boolean {

        var result = false

        for (item in elements) {
            result = remove(item) || result
        }

        return result

    }

    override fun retainAll(elements: Collection<T>): Boolean {

        var result = false
        val iterator = this.iterator()

        while (iterator.hasNext()) {

            val item = iterator.next()

            if (!elements.contains(item)) {

                iterator.remove()
                result = true
            }

        }

        return result

    }

    override fun contains(element: T): Boolean {

        for (item in this) {
            if (item == element) return true
        }

        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        
        for (searched in elements) {
            if (!contains(searched)) return false
        }

        return true
    }

    override fun toString(): String {

        if (isEmpty()) { return "Empty list" }

        else { return head.toString() }

     }

     override fun iterator(): MutableIterator<T> {

        return LinkedListIterator(this)

    }

    fun push(value: T): LinkedList<T> {

        head = Node(value = value, next = head)

        if (tail == null) { tail = head }
        
        size++

        return this

     }

    fun append(value: T): LinkedList<T> {

        if (isEmpty()) {
            push(value)
            return this
        }

        tail?.next = Node(value = value)
        tail = tail?.next
        size++
        return this

    }

    fun nodeAt(index: Int): Node<T>? {

        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        
        return currentNode

    }

    fun insert(value:T, afterNode: Node<T>): Node<T> {

        if (tail == afterNode) {
            append(value)
            return tail!!
         }

        val newNode = Node(value = value, next = afterNode.next)

        afterNode.next = newNode
        size++
        return newNode
     
     }
    
    fun pop(): T? {
        
        if (!isEmpty()) { size-- }

        val result = head?.value
        head = head?.next

        if (isEmpty()) { tail = null }

        return result

    }

    fun removeLast(): T? {
        
        val head = head ?: return null

        if (head.next == null) return pop()
        size--

        var prev = head
        var current = head
        var next = current.next

        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev
        return current.value

    }

    fun removeAfter(node: Node<T>): T? {

        val result = node.next?.value

        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }

        node.next = node.next?.next
        return result

     }

     
 }
        
     
    
