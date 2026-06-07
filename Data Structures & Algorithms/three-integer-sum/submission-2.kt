class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {

        nums.sort()
      
        val result = mutableListOf<List<Int>>()

        for (i in nums.indices) {
            var left = i + 1
            var right = nums.size - 1

            if(i > 0 && nums[i] == nums[i-1]) continue

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                if (sum == 0) {
                    result.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--
                    while(left < nums.size - 1 && nums[left] == nums[left-1]) left++
                    while(right > 0 && nums[right] == nums[right+1]) right--
                } else if (sum > 0) {
                    right--
                } else {
                    left++
                }

               
            }

        }
        return result

    }
}
