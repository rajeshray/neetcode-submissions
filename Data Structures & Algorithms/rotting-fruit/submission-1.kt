class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {

        val queue = ArrayDeque<Pair<Int, Int>>()
        var fresh = 0
    

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 2) {
                    queue.addLast(Pair(i,j))
                }
                if (grid[i][j] == 1) fresh++
            }
        }

        if (fresh == 0) return 0

        return bfs(grid, queue, fresh)
        
    }


    fun bfs(grid: Array<IntArray>, queue: ArrayDeque<Pair<Int, Int>>, freshCount: Int): Int {
       
        val r = grid.size
        val c = grid[0].size
        var mins = 0
        var fresh = freshCount

        while(queue.isNotEmpty()) {
            mins++

            val levelSize = queue.size

            repeat(levelSize) {

            val (i,j) = queue.removeFirst()

            if (i + 1 < r && grid[i+1][j] == 1) {
                grid[i+1][j] = 2
                queue.add(Pair(i+1, j))
                fresh--
            }

            if (i - 1 >= 0 && grid[i-1][j] == 1) {
                grid[i-1][j] = 2
                queue.add(Pair(i-1, j))
                fresh--
            }

            if (j + 1 < c && grid[i][j+1]  == 1) {
                grid[i][j+1] = 2
                queue.add(Pair(i, j+1))
                fresh--
            }

            if (j -1 >= 0 && grid[i][j-1] == 1) {
                grid[i][j-1] = 2
                queue.add(Pair(i, j-1))
                fresh--
            }

            }
        }

        return if (fresh <=0) mins-1 else -1
    }
}
