class Solution {
    fun findMin(nums: IntArray): Int {
        var start = 0
        var end = nums.size - 1

        var mid = 0

        while(start < end) {
            mid = (start + end)/2
            if(nums[end] < nums[mid]) start = mid + 1
            else end = mid
        }

        return nums[end]

    }
}
