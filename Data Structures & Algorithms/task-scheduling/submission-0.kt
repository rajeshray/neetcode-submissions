class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {

        val maxHeap = PriorityQueue<Int> (reverseOrder())
        val freq = IntArray(26)

        for (task in tasks) freq[task - 'A']++

        for (count in freq) if (count > 0) maxHeap.add(count)

        val queue = ArrayDeque<Pair<Int, Int>>()

        var time = 0

        while(queue.isNotEmpty() || maxHeap.isNotEmpty()) {
            if (queue.isNotEmpty()) {
                val (taskCount, processTime) = queue.first()
                if (processTime == time) {
                    maxHeap.add(taskCount)
                    queue.removeFirst()
                }
            }
            if (maxHeap.isNotEmpty()) {
                val count = maxHeap.poll()
                if (count > 1) {
                    queue.addLast(Pair(count-1, time + n + 1))
                } 

            }
            time++
        }

        return time
    }
}
