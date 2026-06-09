class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1Map = IntArray(26)
        val s2Map = IntArray(26)
        var i = 0
        var j = 0

        for (char in s1) s1Map[char - 'a']++
    
        while(j < s2.length) {
            s2Map[s2[j] - 'a']++
          
            if (j - i + 1 == s1.length) {
    
                if (s1Map.contentEquals(s2Map)) return true
                s2Map[s2[i] - 'a']--
                i++
            }
            j++
        }

        return false 

    }
}
