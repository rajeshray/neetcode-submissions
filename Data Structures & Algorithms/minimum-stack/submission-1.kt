class MinStack() {
    val stack = ArrayDeque<Int>()
    val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        val curMin = if (minStack.isEmpty()) `val` else minStack.last()
        if (curMin < `val`) {
            minStack.addLast(curMin)
        } else {
            minStack.addLast(`val`)
        }
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()

    }
}
