class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        
        while(start <= end) {
            val mid = (start + end)/2
            if (nums[mid] == target) return mid
            when {
                nums[mid] < nums[end] -> { // right is sorted
                    if (target > nums[mid] && target <= nums[end]) start = mid + 1
                    else end = mid - 1
                }
                else -> { //left is sorted

                    if (target >= nums[start] && target < nums[mid]) end = mid - 1
                    else start = mid + 1
                }
            }
        }

        return -1

    }
}
