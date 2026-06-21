class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {

        val maxHeap = PriorityQueue<Pair<Int, Double>>( compareByDescending { it.second } )
        val result = Array<IntArray>(k) { IntArray(2) }

        for (i in points.indices) {
            val point = points[i]
            val point0 = point[0].toDouble() 
            val point1 = point[1].toDouble()
            val dist = sqrt(((point0 * point0) + (point1 * point1)))
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
