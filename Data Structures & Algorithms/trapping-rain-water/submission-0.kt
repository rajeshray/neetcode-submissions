class Solution {
    fun trap(height: IntArray): Int {
        val maxLeft = IntArray(height.size)
        val maxRight = IntArray(height.size)

        for (i in height.indices) {
            if (i == 0) {
                maxLeft[i] = height[i]
                continue
            }
            maxLeft[i] = max(height[i], maxLeft[i-1])
        }

        for (i in height.size - 1 downTo 0) {
            if (i == height.size - 1) {
                maxRight[i] = height[i]
                continue
            }
            maxRight[i] = max(height[i], maxRight[i+1])

        }

        var totalWater = 0

        for (i in height.indices) {
            if (i == 0 || i == height.size - 1) {
                continue
            }
            val trappedWater = min(maxLeft[i-1], maxRight[i+1]) - height[i]
            if (trappedWater > 0) totalWater += trappedWater
        }

        return totalWater

    }
}
