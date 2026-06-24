class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {

        val r = board.size
        val c = board[0].size

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == word[0]) {
                    if(backtrack(board, i, j, word, 0)) {
                        return true
                    }
                }
            }
        }

        return false

    }

    fun backtrack(board: Array<CharArray>, i: Int, j: Int, word: String, index: Int): Boolean {
        val r = board.size
        val c = board[0].size

        if (index == word.length) return true
        if (i < 0 || i >=r || j < 0 || j >= c) return false
        if (board[i][j] != word[index]) return false

        val temp = board[i][j]

        board[i][j] = '#'

        val found = backtrack(board, i+1, j, word, index + 1) ||
        backtrack(board, i-1, j, word, index + 1) ||
        backtrack(board, i, j+1, word, index + 1) || 
        backtrack(board, i, j-1, word, index + 1)

        board[i][j] = temp

        return found
    
    }
}
