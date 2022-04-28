class BinTree {
    private var root: Node? = null

    fun print() = root?.printRec(0)
    fun remove(x: Int) { root = root?.removeRec(x) }
    fun add(x: Int) { root = root?.addNodeRec(x) ?: Node(x) }
    fun find(x: Int): Pair<Int, Int>? {
        val res = root?.findNodeRec(x)
        return if(res != null) Pair(res.getValue(), res.getReps())
        else null
    }

    private class Node (
        private var value : Int,
        private var reps: Int = 1,
        private var left : Node? = null,
        private var right : Node? = null) {

        fun getValue() = value
        fun getReps() = reps

        fun printRec(shift: Int) {
            left?.printRec(shift + 1)
            print(" ".repeat(2*shift))
            println("$value $reps")
            right?.printRec(shift + 1)
        }

        fun findNodeRec(x: Int) : Node? = when {
            x < value -> left?.findNodeRec(x)
            x > value -> right?.findNodeRec(x)
            else -> this
        }

        fun addNodeRec(x: Int): Node {
            if(x < value)
                left = left?.addNodeRec(x) ?: Node(x)
            else if(x > value)
                right = right?.addNodeRec(x) ?: Node(x)
            else reps++
            return this
        }

        fun removeRec(x: Int): Node? {
            if(x < value) left = left?.removeRec(x)
            else if(x > value) right = right?.removeRec(x)
            else {
                // 0 или 1 ребенок
                if(left == null) return right
                else if(right == null) return left

                // 2 ребенка - надо искать в глубине преемника
                val heir: Node? = findHeir()
                this.copy(heir!!)
                right = right?.removeRec(heir.value)
            }
            return this
        }

        // поиск наследника для удаленного элемента (мин элемент правого поддерева)
        private fun findHeir(): Node {
            var temp = this.right!!
            while(temp.left != null)
                temp = temp.left!!
            return temp
        }

        private fun copy(other: Node) {
            value = other.value
            reps = other.reps
        }
    }

}