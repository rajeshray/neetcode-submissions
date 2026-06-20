class Solution {
    fun climbStairs(n: Int): Int {
        if (n < 3) return n

        val sol = IntArray(n+1)
        var prev1 = 2
        var prev2 = 1


        for (i in 3..n) {
            val curr = prev1 + prev2
            prev2 = prev1
            prev1 = curr
        }

        return prev1

    }
}
