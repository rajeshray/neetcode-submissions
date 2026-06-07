class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1

        while(start < end) {
            val mid = (start + end)/2
            if (nums[mid] < target) start = mid+1
            else end = mid
        }

        if (nums[start] == target) return start else return -1

    }
}
