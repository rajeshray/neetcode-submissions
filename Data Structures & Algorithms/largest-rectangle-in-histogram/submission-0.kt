class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Int>()
        var maxArea = 0
        val n = heights.size

        for (i in heights.indices) {
            
            while(stack.isNotEmpty() && heights[stack.last()] > heights[i]) {
                val barIndex = stack.removeLast()
                val pse = if (stack.isNotEmpty()) stack.last() else -1
                val area = ((i - pse) - 1) * heights[barIndex]
                maxArea = max(area, maxArea)
            }
           
            stack.addLast(i)
        }

        while(stack.isNotEmpty()) {
            val barIndex = stack.removeLast()
            val pse =  if (stack.isNotEmpty()) stack.last() else -1
            val area = ((n - pse) - 1) * heights[barIndex]
            maxArea = max(area, maxArea)
        }

        return maxArea

    }
}
