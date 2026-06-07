class Solution {
    fun findMin(nums: IntArray): Int {
        var start = 0
        var end = nums.size - 1

        while(start < end) {
            val mid = (start + end)/2
            if(nums[end] < nums[mid]) start = mid + 1
            else end = mid
        }

        return nums[start]

    }
}
