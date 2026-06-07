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
            var end = start
            while(end < str.length && str[end] != '#') end++

            val wordSize = str.substring(start, end).toInt()

            start = end + 1

            result.add(str.substring(start, start + wordSize))
            start += wordSize
        }

        return result

    }
}
