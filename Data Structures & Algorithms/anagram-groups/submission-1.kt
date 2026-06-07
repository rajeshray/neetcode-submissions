class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        
        val result = mutableListOf<List<String>>()
        val map = mutableMapOf<String, MutableList<String>>()

        for(str in strs) {
            val strCharArray = str.toCharArray()
            strCharArray.sort()
            val sortedString = strCharArray.joinToString("")
            val mapTT = map.getOrPut(sortedString) {mutableListOf<String>()}
            mapTT.add(str)
        }


       for ((key,value) in map) {
        result.add(value.toList())
       }

       return result

    }
}
