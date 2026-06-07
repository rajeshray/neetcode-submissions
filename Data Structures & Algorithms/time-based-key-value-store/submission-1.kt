class TimeMap() {

    val storeMap = mutableMapOf<String, Array<String>>()

    fun set(key: String, value: String, timestamp: Int) {
        if (!storeMap.containsKey(key)) {
            storeMap[key] = Array(1100) { "" }
        }
        storeMap[key]!![timestamp] = value

    }

    fun get(key: String, timestamp: Int): String {
        val stringArr = storeMap[key] ?: return ""
        for(i in timestamp downTo 1) {
            if (stringArr[i].isNotEmpty() == true) return stringArr[i]
        }

        return ""

    }
}
