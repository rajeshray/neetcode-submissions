class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val row = Array(9) { mutableSetOf<Char>() }
        val col = Array(9) { mutableSetOf<Char>() }
        val box = Array(9) { mutableSetOf<Char>() }

        for ( i in 0..8) {
            for (j in 0..8) {
                val c = board[i][j]
                if (c == '.') continue
                val boxIndex = ((i/3) * 3) + (j/3)
                if (row[i].contains(c) || col[j].contains(c) || box[boxIndex].contains(c)) {
                    return false
                }
                row[i].add(c)
                col[j].add(c)
                box[boxIndex].add(c)
            }
        }

        return true
    }
}
