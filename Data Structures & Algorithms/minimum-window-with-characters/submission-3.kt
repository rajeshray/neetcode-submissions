class Solution {
    fun minWindow(s: String, t: String): String {
        val tFreq = IntArray(128)
        val sFreq = IntArray(128)

        for (ch in t) {
            tFreq[ch.code]++
        }

        val uniqueChars = tFreq.count { it > 0 }

        var i = 0
        var j = 0
        var resultStart = 0
        var minLen = Int.MAX_VALUE
        var formed = 0

        while( j < s.length) {
            sFreq[s[j].code]++

            if (sFreq[s[j].code] != 0 && sFreq[s[j].code] == tFreq[s[j].code]) formed++

            if (formed == uniqueChars) {
                while(formed == uniqueChars && i <= j) {
                    if (j - i + 1 <= minLen) {
                        resultStart = i
                        minLen = j - i + 1
                    }

                    if (sFreq[s[i].code] == tFreq[s[i].code]) formed--

                    sFreq[s[i].code]--
                    i++
                }
            }
            j++
        }

        return if (minLen == Int.MAX_VALUE) return "" else s.substring(resultStart, resultStart + minLen)

    }
}
