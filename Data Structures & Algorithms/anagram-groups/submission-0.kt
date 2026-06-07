class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        
        val sortedStrings = mutableListOf<String>()
        val result = mutableListOf<List<String>>()
        val map = mutableMapOf<String, MutableList<String>>()

        for(str in strs) {
            val strCharArray = str.toCharArray()
            strCharArray.sort()
            sortedStrings.add(strCharArray.joinToString(""))
        }

       for (i in sortedStrings.indices) {
           val each = map.getOrPut(sortedStrings[i]) {mutableListOf<String>()}
           each.add(strs[i])
       }

       for ((key,value) in map) {
        result.add(value.toList())
       }

       return result

    }
}
