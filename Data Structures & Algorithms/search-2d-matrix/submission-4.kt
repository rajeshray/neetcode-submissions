class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var start = 0
        var end = (matrix.size * matrix[0].size) - 1

        val colSize = matrix[0].size
        

        while(start <= end) {
            val mid = (start + end)/2
            val row = mid/colSize
            val col = mid%colSize
            if (matrix[row][col] == target) return true
            else if (matrix[row][col] < target) start = mid + 1
            else end = mid - 1
        }
        return false

    }
}
