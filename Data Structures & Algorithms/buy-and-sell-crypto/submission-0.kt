class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var minSoFar = Int.MAX_VALUE
        for (price in prices) {
            if (price < minSoFar) {
                minSoFar = price
            } else {
                maxProfit = max(maxProfit, price - minSoFar)
            }

        }

        return maxProfit

    }
}
