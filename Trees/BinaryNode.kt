package DataStructures_and_Algorithms.Trees

typealias BinaryVisitor<T> = (T) -> Unit

class BinaryNode<T>(var value: T) {

        var leftChild: BinaryNode<T>? = null
        var rightChild: BinaryNode<T>? = null

        val min: BinaryNode<T>?
            get() = leftChild?.min ?: this

        override fun toString() = diagram(this)

        private fun diagram(node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""): String {

        return node?.let {

            if (node.leftChild == null && node.rightChild == null) {

                "$root${node.value}\n"

            } else {

                diagram(node.rightChild, "$top ", "$top,__", "$top| ") +
                 root + "${node.value}\n" + diagram(node.leftChild,
                "$bottom| ", "$bottom '--", "$bottom ")

            }

        } ?: "${root}null\n"

    }

    fun traverseInOrder(visit: BinaryVisitor<T>) {

        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
        
    }

    fun traversePreOrder(visit: BinaryVisitor<T>) {

        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)

    }

    fun traversePostOrder(visit: BinaryVisitor<T>) {

        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)

    }

    fun traversePreOrderWithNull(visit: BinaryVisitor<T?>) {

        visit(value)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
  
    }

    fun serialize(node: BinaryNode<T> = this): MutableList<T?> {

       val list = mutableListOf<T?>()
       node.traversePreOrderWithNull { list.add(it) }
       return list 

    }

    fun deserialize(list: MutableList<T?>): BinaryNode<T?>? {

        val rootValue = list.removeAt(list.size - 1) ?: return null

        val root = BinaryNode<T?>(rootValue)

        root.leftChild = deserialize(list)
        root.rightChild = deserialize(list)

        return root

    }

    fun deserializeOptimized(list: MutableList<T?>): BinaryNode<T?>? {

        return deserialize(list.asReversed())
    
    }
}
