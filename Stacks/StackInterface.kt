package DataStructures_and_Algorithms.Stacks

interface StackInterface<T>{

    fun pop(): T?

    fun push(element: T)

    fun peek(): T?

    val count : Int

    val isEmpty: Boolean
        get() = count == 0

    }
