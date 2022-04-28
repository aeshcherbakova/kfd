val menu = """
    1. add key
    2. remove key
    3. find key
    4. print tree
    0. exit
""".trimIndent()

fun addElements(tree: BinTree) {

    val list = List(100) {i -> i}
    println(list)

    while(true) {
        println("\nInput one or more keys to add in the tree:")
        try {
            val arr = readLine()!!.trim().split(", ", " ", ",").map { it.toInt() }
            arr.forEach { tree.add(it) }
            return
        } catch (e: Exception) {
            println("Invalid input! Try again")
        }
    }
}

fun removeElement(tree: BinTree) {
    while(true) {
        println("Input one key to remove from the tree: ")
        try {
            val input = readLine()!!.toInt()
            tree.remove(input)
            return
        } catch (e: Exception) {
            println("Invalid input! Try again")
        }
    }
}

fun findElement(tree: BinTree) {
    while(true) {
        println("Input one key to find in the tree: ")
        try {
            val input = readLine()!!.toInt()
            val node = tree.find(input)
            if (node == null) println("Element not found")
            else println("Value = ${node.first}, reps = ${node.second}")
            return
        } catch (e: Exception) {
            println("Invalid input! Try again")
        }
    }
}


fun main() {
    val tree = BinTree()

    while(true) {
        println("\n" + menu)
        print("Your choice: ")
        when(readLine()) {
            "1" -> addElements(tree)
            "2" -> removeElement(tree)
            "3" -> findElement(tree)
            "4" -> tree.print()
            "0" -> break
            else -> println("Invalid input! Try again")
        }
    }
}