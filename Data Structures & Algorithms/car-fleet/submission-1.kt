class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {

        val stack = ArrayDeque<Pair<Int, Double>>()
        val timeTaken = DoubleArray(position.size)
        val map = TreeMap<Int, Double>(reverseOrder())

        for (i in position.indices) {
            timeTaken[i] = (target.toDouble() - position[i].toDouble())/speed[i].toDouble()
            map[position[i]] = timeTaken[i]
        }

        var fleet = 0

        for ((key, value) in map) {


            if (stack.isNotEmpty() && value > stack.first().second) {
                stack.clear()
                fleet++
            }

            stack.addLast(key to value)
            
        }
        if (stack.isNotEmpty()) fleet++

        return fleet

    }
}
