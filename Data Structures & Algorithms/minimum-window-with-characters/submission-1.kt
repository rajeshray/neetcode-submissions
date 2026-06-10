class Solution {
    fun minWindow(s: String, t: String): String {
        val len = t.length
        val sMap = mutableMapOf<Char, Int>()
        val tMap = mutableMapOf<Char, Int>()

        for (ch in t) {
            tMap[ch] = tMap.getOrDefault(ch, 0) + 1
        }

        var windowSize = len

        while(windowSize <= s.length) {

            var i = 0

        for (j in s.indices) {
            sMap[s[j]] = sMap.getOrDefault(s[j], 0) + 1
            if ( j - i + 1 == windowSize) {
              //  println("substring = ${s.substring(i, j+1)}")


                var isWindowValid = true


                for ((key, value) in tMap) {
                   // println("key, value = $key, $value")

                    if (!sMap.contains(key) || (sMap.contains(key) && sMap[key]!! < value)) {
                        isWindowValid = false
                    }
                }

                if(isWindowValid) return s.substring(i, j + 1)


                sMap[s[i]] = sMap.getOrDefault(s[i], 0) - 1
                i++
            }


        }
        sMap.clear()
        windowSize++

        }

        return ""

    }
}
