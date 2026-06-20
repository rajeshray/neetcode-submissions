class Solution {
    fun climbStairs(n: Int): Int {
        if (n < 3) return n

        val sol = IntArray(n+1)
        sol[0] = 0
        sol[1] = 1
        sol[2] = 2

        for (i in 3..n) {
            sol[i] = sol[i-1] + sol[i-2]
        }

        return sol[n]

    }
}
