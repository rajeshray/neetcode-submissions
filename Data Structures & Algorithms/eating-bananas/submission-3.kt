class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {

        var start = 1
        var end = piles.max()

        while(start < end) {
            val mid = (start + end)/2
            var totalHrsTaken = 0
            for (i in piles) {
                totalHrsTaken += (i + mid - 1)/mid
            }
            if (totalHrsTaken > h) {
                start = mid + 1
            } else end = mid

        }
        return end

    }
}
