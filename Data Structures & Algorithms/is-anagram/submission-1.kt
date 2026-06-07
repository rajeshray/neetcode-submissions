class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val countMap = mutableMapOf<Char, Int>()
        val countMapNew = mutableMapOf<Char, Int>()
        if (s.length != t.length) return false
        for (eachChar in s) {
            countMap[eachChar] = countMap.getOrDefault(eachChar, 0) + 1
        }
        for (eachChar in t) {
            countMapNew[eachChar] = countMapNew.getOrDefault(eachChar, 0) + 1
        }

        for ((char, count) in countMap) {
            val countInT = countMapNew.getOrDefault(char, 0)
            if (countInT != count) return false
        }

        return true
    }
}
