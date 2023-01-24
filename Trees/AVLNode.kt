package DataStructures_and_Algorithms.Trees

typealias AVLVisitor<T> = (T) -> Unit

class AVLNode<T>(var value: T) {

        var leftChild: AVLNode<T>? = null
        var rightChild: AVLNode<T>? = null

        val min: AVLNode<T>?
            get() = leftChild?.min ?: this

        var height = 0

        val leftHeight: Int
            get() = leftChild?.height ?: -1

        val rightHeight: Int
            get() = rightChild?.height ?: -1

        val balanceFactor: Int
            get() = leftHeight - rightHeight

        override fun toString() = diagram(this)

        private fun diagram(node: AVLNode<T>?,
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

    fun traverseInOrder(visit: AVLVisitor<T>) {

        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
        
    }

    fun traversePreOrder(visit: AVLVisitor<T>) {

        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)

    }

    fun traversePostOrder(visit: AVLVisitor<T>) {

        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)

    }

    fun traversePreOrderWithNull(visit: AVLVisitor<T?>) {

        visit(value)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)

    }

    fun serialize(node: AVLNode<T> = this): MutableList<T?> {

       val list = mutableListOf<T?>()
       node.traversePreOrderWithNull { list.add(it) }
       return list 

    }

    fun deserialize(list: MutableList<T?>): AVLNode<T?>? {

        val rootValue = list.removeAt(list.size - 1) ?: return null

        val root = AVLNode<T?>(rootValue)

        root.leftChild = deserialize(list)
        root.rightChild = deserialize(list)

        return root

    }

    fun deserializeOptimized(list: MutableList<T?>) : AVLNode<T?>? {

        return deserialize(list.asReversed())
    
    }

}
