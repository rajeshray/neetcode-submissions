class Solution {
    fun trap(height: IntArray): Int {
       val s = height.size
       var i = 0
       var j = s - 1
       var maxLeft = 0
       var maxRight = 0
       var totalWater = 0

       while(i <= j) {
        val trappedWater: Int
        if (maxLeft <= maxRight) {
            maxLeft = max(maxLeft, height[i])
            trappedWater = maxLeft - height[i]
            i++
        } else {
            maxRight = max(maxRight, height[j])
            trappedWater = maxRight - height[j]
            j--
        }
         totalWater += trappedWater
       }

       return totalWater 

    }
}
