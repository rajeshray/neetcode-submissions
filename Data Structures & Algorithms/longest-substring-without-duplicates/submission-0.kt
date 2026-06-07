class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var end = 0
        var maxLength = 0
        while(end < s.length) {


            //println(temp)
            maxLength = max(maxLength, (end - start)+1)

            end++

            while(start < end && end < s.length && s.substring(start, end).contains(s[end])) {
                start++
            }

        }

        return maxLength

    }
}
