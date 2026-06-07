class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        
        val map = mutableMapOf<String, MutableList<String>>()

        for(str in strs) {
            val strCharArray = str.toCharArray()
            val charFreq = IntArray(26) {0}
            for (eachChar in str) {
                charFreq[eachChar - 'a'] = charFreq[eachChar - 'a'] + 1
            }
            val mapTT = map.getOrPut(charFreq.joinToString(",")) {mutableListOf<String>()}
            mapTT.add(str)
        }


       return map.values.toList()

    }
}
