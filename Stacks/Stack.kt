package DataStructures_and_Algorithms.Stacks

import DataStructures_and_Algorithms.Stacks.StackInterface

class Stack<T>: StackInterface<T> {

    private var storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun peek(): T? {
        return storage.lastOrNull()
        }

    override fun pop(): T? {
        return storage.removeLastOrNull()
        }

    override fun push(element: T) {
        storage.add(element)
        }
}
    fun String.validParentheses(): Boolean{

        val stack = Stack<Char>()

        for (char in this) {
            when (char) {
                '(' -> {
                    stack.push(char)
                    }
                ')' -> {
                    if (stack.isEmpty) {
                        return false
                        } else { stack.pop() }
                    }
                }
            }
        return stack.isEmpty
    }

