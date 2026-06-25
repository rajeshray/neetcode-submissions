class Solution {
    val result = mutableListOf<String>()
    val letterMap = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )
    fun letterCombinations(digits: String): List<String> {
        if (digits.length == 0) return emptyList()
        backtrack(digits,StringBuilder(), 0)
        return result
    }

    fun backtrack(digits: String, current: StringBuilder, index: Int) {
        if (index == digits.length) {
            result.add(String(current))
            return
        }
        val chars = letterMap.getOrDefault(digits[index], "")

        for (char in chars) {
            current.append(char)
            backtrack(digits, current, index + 1)
            current.deleteCharAt(current.length - 1)
        }

    }
}
