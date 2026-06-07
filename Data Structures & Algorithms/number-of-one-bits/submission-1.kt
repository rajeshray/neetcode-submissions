class Solution {
    fun hammingWeight(n: Int): Int {
        var step = n
        var count = 0
        while(step != 0) {
            count++
            step = step and (step - 1)
        }
        return count
    }
}
