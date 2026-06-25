class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {

        var maxArea = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) maxArea = max(maxArea, bfs(grid, i, j))
            }
        }

        return maxArea

    }

     fun bfs(grid: Array<IntArray>, ipos: Int, jpos: Int): Int {
        val r = grid.size
        var c = grid[0].size

        val queue = ArrayDeque<Pair<Int, Int>>()

        queue.addLast(Pair(ipos,jpos))
        grid[ipos][jpos] = -1

        var area = 0

        while (queue.isNotEmpty()) {
            val (i, j) = queue.removeFirst()
            area++

            if (i + 1 < r && grid[i+1][j] == 1) {
                queue.addLast(Pair(i+1, j))
                grid[i+1][j] = -1
            } // moving right

            if (i - 1 >= 0 && grid[i-1][j] == 1) {
                queue.addLast(Pair(i-1, j))
                grid[i-1][j] = -1
            } // moving left

            if (j + 1 < c && grid[i][j+1] == 1) {
                queue.addLast(Pair(i, j+1))
                grid[i][j+1] = -1
            } // moving down

            if (j-1 >= 0 && grid[i][j-1] == 1) {
                queue.addLast(Pair(i, j-1))
                grid[i][j-1] = -1
            } // moving up

        }

        return area


    }



}
