class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val r = grid.size
        val c = grid[0].size

         val queue = ArrayDeque<Pair<Int, Int>>()

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 0) {
                    queue.addLast(Pair(i,j))
                }
            }
        }

        bfs(grid, queue)
    }

    fun bfs(grid: Array<IntArray>, queue: ArrayDeque<Pair<Int, Int>>) {
       
        val r = grid.size
        val c = grid[0].size

        while(queue.isNotEmpty()) {
            val (i,j) = queue.removeFirst()

            if (i + 1 < r && grid[i+1][j] == Int.MAX_VALUE) {
                grid[i+1][j] = min(grid[i+1][j], grid[i][j] + 1)
                queue.add(Pair(i+1, j))
            }

            if (i - 1 >= 0 && grid[i-1][j] == Int.MAX_VALUE) {
                grid[i-1][j] = min(grid[i-1][j], grid[i][j] + 1)
                queue.add(Pair(i-1, j))
            }

            if (j + 1 < c && grid[i][j+1]  == Int.MAX_VALUE) {
                grid[i][j+1] = min(grid[i][j+1], grid[i][j] + 1)
                queue.add(Pair(i, j+1))
            }

            if (j -1 >= 0 && grid[i][j-1] == Int.MAX_VALUE) {
                grid[i][j-1] = min(grid[i][j-1], grid[i][j] + 1)
                queue.add(Pair(i, j-1))
            }

        }
    }
}
