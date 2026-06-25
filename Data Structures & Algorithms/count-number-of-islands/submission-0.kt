class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        
        var count = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j)
                    count++
                }
            }
        }

        return count
    }


    fun bfs(grid: Array<CharArray>, ipos: Int, jpos: Int) {
        val r = grid.size
        var c = grid[0].size

        val queue = ArrayDeque<Pair<Int, Int>>()

        queue.addLast(Pair(ipos,jpos))
        grid[ipos][jpos] = '#'

        while (queue.isNotEmpty()) {
            val (i, j) = queue.removeFirst()

            if (i + 1 < r && grid[i+1][j] == '1') {
                queue.addLast(Pair(i+1, j))
                grid[i+1][j] = '#'
            } // moving right

            if (i - 1 >= 0 && grid[i-1][j] == '1') {
                queue.addLast(Pair(i-1, j))
                grid[i-1][j] = '#'
            } // moving left

            if (j + 1 < c && grid[i][j+1] == '1') {
                queue.addLast(Pair(i, j+1))
                grid[i][j+1] = '#'
            } // moving down

            if (j-1 >= 0 && grid[i][j-1] == '1') {
                queue.addLast(Pair(i, j-1))
                grid[i][j-1] = '#'
            } // moving up

        }


    }


    

}
