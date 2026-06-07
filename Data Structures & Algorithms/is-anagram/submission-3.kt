class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val countMap = mutableMapOf<Char, Int>()
        if (s.length != t.length) return false
        for (i in 0..s.length-1) {
            countMap[s[i]] = countMap.getOrPut(s[i]) { 0 } + 1
            countMap[t[i]] = countMap.getOrPut(t[i]) { 0 } - 1
        }

       return countMap.values.all {it == 0}

    }
}
