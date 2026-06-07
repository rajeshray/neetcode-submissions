class TimeMap() {

    val storeMap = mutableMapOf<String, MutableList<Pair<String, Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        if (!storeMap.containsKey(key)) {
            storeMap[key] = mutableListOf()
        }
        storeMap[key]!!.add(Pair(value, timestamp))

    }

    fun get(key: String, timestamp: Int): String {
        val valueList = storeMap.getOrDefault(key, emptyList())
        if (valueList.isEmpty()) return ""

        var start = 0 
        var end = valueList.size-1

        while(start <= end) {
            val mid = (start + end)/2
            val (value, time) = valueList[mid]
            if (time == timestamp) return value
            else if (time < timestamp) start = mid + 1
            else end = mid - 1
        }
        if (start-1 < 0) return "" else return valueList[start-1].first

    }
}
