class Solution {
    val finalList = mutableListOf<String>()
    fun generateParenthesis(n: Int): List<String> {
        backtrack(StringBuilder(),n, 0,0)
        return finalList
    }


    fun backtrack(string: StringBuilder, n: Int, openCount: Int, closeCount: Int) {
        if (2 * n == openCount + closeCount) {
            finalList.add(String(string))
            return
        }

        if (closeCount > openCount) {
            return
        }


        if (openCount < n) {
            string.append('(')
            backtrack(string, n, openCount + 1, closeCount)
            string.deleteCharAt(string.length - 1)
        }
         if(closeCount < openCount) {
            string.append(')')
            backtrack(string, n, openCount, closeCount + 1)
            string.deleteCharAt(string.length - 1)
        }
        
    }
}
