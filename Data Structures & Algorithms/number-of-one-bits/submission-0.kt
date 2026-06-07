class Solution {
    fun hammingWeight(n: Int): Int {
        var step = n
        var count = 0
        while(step > 0) {
            count += step and 1
            step = step shr 1
        }
        return count
    }
}
