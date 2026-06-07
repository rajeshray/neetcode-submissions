class Solution {

    fun encode(strs: List<String>): String {
        val finalString = StringBuilder()
        for (str in strs) {
            finalString.append("${str.length}")
            finalString.append("#")
            finalString.append(str)
        }
        return finalString.toString()
    }

    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()
        var start = 0
        while(start < str.length) {
            var stringSize = StringBuilder()
            while(str[start] != '#' && start < str.length) {
                stringSize.append(str[start])
                start++
            }

            start++ 
            val decodedString = StringBuilder()
            val wordSize = stringSize.toString().toInt()
            val decrptWord = str.substring(start, start + wordSize)
            decodedString.append(decrptWord)
            result.add(decodedString.toString())
            start += wordSize
        }

        return result

    }
}
