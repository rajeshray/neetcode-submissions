class MinStack() {
    val stack = ArrayDeque<Int>()
    val minHeap = PriorityQueue<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        minHeap.add(`val`)
    }

    fun pop() {
        val el = stack.removeLast()
        minHeap.remove(el)
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minHeap.peek()

    }
}
