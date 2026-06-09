class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var left = 0
        var right = 0
        val freMap = mutableMapOf<Char, Int>()
        var maxLen = 0

        while(right < s.length) {
            freMap[s[right]] = freMap.getOrDefault(s[right], 0) + 1
            val diff = (right - left + 1) - freMap.values.max()
            if (diff > k) {
                freMap[s[left]] = freMap[s[left]]!! - 1
                left++
            } else {
                maxLen = max(maxLen, right - left + 1)
            }
            right++
        }
        return maxLen

    }
}
