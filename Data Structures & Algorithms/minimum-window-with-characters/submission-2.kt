class Solution {
    fun minWindow(s: String, t: String): String {
        val len = t.length
        val sMap = mutableMapOf<Char, Int>()
        val tMap = mutableMapOf<Char, Int>()

        for (ch in t) {
            tMap[ch] = tMap.getOrDefault(ch, 0) + 1
        }

        var i = 0
        var j = 0
        var result = ""
        var formed = 0
        var minLen = Int.MAX_VALUE

        while(j < s.length) {
            sMap[s[j]] = sMap.getOrDefault(s[j], 0) + 1
            if (tMap.contains(s[j]) && sMap[s[j]]!! == tMap[s[j]]!!) formed++
            if (formed == tMap.size) {
                while(formed == tMap.size && i <= j) {
                    if (j - i + 1 < minLen) {
                        result = s.substring(i, j+1)
                        minLen = j - i + 1
                    }
                    if (tMap.contains(s[i]) && tMap[s[i]] == sMap[s[i]]) formed--
                    sMap[s[i]] = sMap.getOrDefault(s[i], 0) - 1
                    i++
                }
            }
            j++
        }
        return result

    }
}
