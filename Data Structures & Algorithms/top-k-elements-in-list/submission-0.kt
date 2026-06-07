class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freMap = mutableMapOf<Int, Int>()
        val finalList = mutableListOf<Int>()
        val bucket = Array(nums.size + 1) { mutableListOf<Int>() }
        for (eachNum in nums) {
            freMap[eachNum] = freMap.getOrDefault(eachNum, 0) + 1
        }

        for ((key, value) in freMap) {
            bucket[value].add(key)
        }

        var kCount = k

        for (i in nums.size downTo 1) {
            if (kCount <= 0) break
            if (bucket[i].size >=0) {
                kCount -= bucket[i].size
                finalList.addAll(bucket[i])
            }
        }

        return finalList.toIntArray()

    }
}
