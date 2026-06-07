class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Pair<Int, Int>>() 
        val result = IntArray(temperatures.size) {0}
        for (i in temperatures.indices) {
              while (stack.isNotEmpty() && stack.last().second < temperatures[i]) {
                    val (index, value) = stack.removeLast()
                    result[index] = i - index
                }
                stack.addLast(Pair(i, temperatures[i]))
        }
        return result
    }
}
