class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {

        val queue = ArrayDeque<Pair<Int, Int>>()
    

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 2) {
                    queue.addLast(Pair(i,j))
                }
            }
        }

        return bfs(grid, queue)
        
    }


    fun bfs(grid: Array<IntArray>, queue: ArrayDeque<Pair<Int, Int>>): Int {
       
        val r = grid.size
        val c = grid[0].size
        var mins = 0

        val sol = Array(r) { IntArray(c) }

        while(queue.isNotEmpty()) {
            val (i,j) = queue.removeFirst()
            mins = max(mins, sol[i][j])

            if (i + 1 < r && grid[i+1][j] == 1) {
                grid[i+1][j] = 2
                sol[i+1][j] = sol[i][j] + 1
                queue.add(Pair(i+1, j))
            }

            if (i - 1 >= 0 && grid[i-1][j] == 1) {
                grid[i-1][j] = 2
                sol[i-1][j] = sol[i][j] + 1
                queue.add(Pair(i-1, j))
            }

            if (j + 1 < c && grid[i][j+1]  == 1) {
                grid[i][j+1] = 2
                sol[i][j+1] = sol[i][j] + 1
                queue.add(Pair(i, j+1))
            }

            if (j -1 >= 0 && grid[i][j-1] == 1) {
                grid[i][j-1] = 2
                sol[i][j-1] = sol[i][j] + 1
                queue.add(Pair(i, j-1))
            }

        }
        
         for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    return -1
                }
            }
        }

        return mins
    }
}
