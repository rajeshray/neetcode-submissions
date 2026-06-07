class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Int>() 
        val result = IntArray(temperatures.size) {0}
        for (i in temperatures.indices) {
              while (stack.isNotEmpty() && temperatures[stack.last()] < temperatures[i]) {
                    val index = stack.removeLast()
                    result[index] = i - index
                }
                stack.addLast(i)
        }
        return result
    }
}
