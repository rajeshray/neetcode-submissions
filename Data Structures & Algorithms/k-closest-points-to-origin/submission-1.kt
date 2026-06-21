class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {

        val maxHeap = PriorityQueue<Pair<Int, Int>>( compareByDescending { it.second } )
        val result = Array<IntArray>(k) { IntArray(2) }

        for (i in points.indices) {
            val point = points[i]
            val dist = (point[0] * point[0]) + (point[1] * point[1])
            maxHeap.add(Pair(i, dist))
            if (maxHeap.size > k) {
                maxHeap.poll()
            }
        }

        for (i in 0 until k) {
            val point = maxHeap.poll()
            result[i] = points[point.first]
        }

        return result

    }
}
