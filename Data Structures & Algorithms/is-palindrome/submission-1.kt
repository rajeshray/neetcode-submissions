class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while(left < right) {
            while(left < right && !isAlphanumeric(s[left])) left++
            while(left < right && !isAlphanumeric(s[right])) right--

            if (s[left].lowercaseChar() != s[right].lowercaseChar()) return false

            left++
            right--
        }

        return true

    }

    fun isAlphanumeric(char: Char): Boolean {
        if (char >= 'a' && char <= 'z') return true
        if (char >= 'A' && char <= 'Z') return true
        if (char >= '0' && char <= '9') return true
        return false
    }
}
