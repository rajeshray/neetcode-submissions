class LRUCache(val capacity: Int) {

    class Node(val key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    val head = Node(0,0)
    val tail = Node(0,0)
    val map = HashMap<Int, Node>()

    init {
        head?.next = tail
        tail?.prev = head
    }

    fun get(key: Int): Int {
        if (map.contains(key)) {
            val node = map[key]!!
            remove(node)
            addToFront(node)
            return node!!.value
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (map.contains(key)) {
            val node = map[key]!!
            remove(node)
            addToFront(node)
            node.value = value
        } else {
            val node = Node(key, value)
            map[key] = node
            addToFront(node)

            if (map.size > capacity) {
                val lru = tail?.prev!!
                remove(lru)
                map.remove(lru.key)
            }
        }


    }

    fun remove(node: Node) {
       node?.prev?.next = node?.next
       node?.next?.prev = node?.prev
    }

    fun addToFront(node: Node) {
        val next = head?.next
        head?.next = node
        node?.prev = head
        node?.next = next
        next?.prev = node
    }
}
