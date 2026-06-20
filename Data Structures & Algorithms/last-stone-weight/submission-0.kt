class Solution {
    fun lastStoneWeight(stones: IntArray): Int {

        val pq = PriorityQueue<Int>(compareByDescending { it })

        for (stone in stones) pq.add(stone)


        while(pq.isNotEmpty()) {
            val s1 = pq.poll()
            if (pq.isEmpty()) return s1
            val s2 = pq.poll()

            if (s1 != s2) {
                pq.add(abs(s1-s2))
            }
        }

        return 0

    }
}
