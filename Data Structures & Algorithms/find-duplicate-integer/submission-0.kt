class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = 0
        var fast = 0
        var meetingPoint = 0
        while(true) {
            slow = nums[slow]
            fast = nums[nums[fast]]
            
             if (nums[slow] == nums[fast]) {
                meetingPoint = slow
                break
            }
        }

        var slow2 = 0

        while(true) {
            if (nums[slow] == nums[slow2]) {
                return nums[slow]
            }
            slow2 = nums[slow2]
            slow = nums[slow]
        }

        return -1

    }
}
