class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var end = 0
        var maxLength = 0
        val charSet = mutableSetOf<Char>()
        while(end < s.length) {

            maxLength = max(maxLength, (end - start)+1)
            charSet.add(s[end])
            end++

            while(start < end && end < s.length && charSet.contains(s[end])) {
                charSet.remove(s[start])
                start++
            }

        }

        return maxLength

    }
}
