class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {

        val map = TreeMap<Int, Double>(reverseOrder())

        for (i in position.indices) {
            map[position[i]] = (target - position[i]).toDouble() / speed[i]
        }

        var fleet = 0
        var leaderTime:Double = 0.0

        for ((_, time) in map) {
            if (time > leaderTime) {
                fleet++
                leaderTime = time
            }
        }

        return fleet

    }
}
