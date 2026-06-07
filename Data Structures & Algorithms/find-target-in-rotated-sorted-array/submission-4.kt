class Solution {
    fun search(nums: IntArray, target: Int): Int {
         var start = 0
        var end = nums.size - 1

        while(start < end) {
            val mid = (start + end)/2
            if(nums[end] < nums[mid]) start = mid + 1
            else end = mid
        }

        val defPoint = start

        if (target == nums[defPoint]) return defPoint

        start = 0
        end = defPoint

        while(start <= end) {
            val mid = (start + end)/2
            if (nums[mid] == target) return mid
            else if(target < nums[mid]) end = mid - 1
            else start = mid + 1
        }

        start = defPoint
        end = nums.size - 1

        while(start <= end) {
            val mid = (start + end)/2
            if (nums[mid] == target) return mid
            else if(target < nums[mid]) end = mid - 1
            else start = mid + 1
        }

        return -1

    }
}
