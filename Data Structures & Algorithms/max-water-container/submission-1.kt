class Solution {
    fun maxArea(heights: IntArray): Int {
        var maxWater = 0
        var left = 0
        var right = heights.size-1

        while(left < right) {
            val tempWaterArea = min(heights[left], heights[right]) * (right - left)
            maxWater = max(tempWaterArea, maxWater)
            if (heights[left] < heights[right]) left++
            else right--
        }

        return maxWater

    }
}
