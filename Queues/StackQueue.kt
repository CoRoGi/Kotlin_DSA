package DataStructures_and_Algorithms.Queues

import DataStructures_and_Algorithms.Stacks.Stack
import DataStructures_and_Algorithms.Queues.Queue

class StackQueue<T> : Queue<T> {

    private val leftStack = Stack<T>()
    private val rightStack = Stack<T>()
    
    override val count: Int
        get() = leftStack.count + rightStack.count

    override val isEmpty: Boolean 
        get() = leftStack.isEmpty && rightStack.isEmpty

    private fun transferElements() {

        var nextElement = rightStack.pop()

        while (nextElement != null) {

            leftStack.push(nextElement)
            nextElement = rightStack.pop()

        }

    }

    override fun peek(): T? {

        if (leftStack.isEmpty) {

            transferElements()

        }

        return leftStack.peek()

    }

    override fun enqueue(element: T): Boolean {

        rightStack.push(element)
        return true

    }


    override fun dequeue(): T? {

        if (leftStack.isEmpty) {

            transferElements()

        }

        return leftStack.pop()

    }

    override fun toString(): String {

        return "Left Stack: \n $leftStack \n Right Stack: \n $rightStack"

    }

}
