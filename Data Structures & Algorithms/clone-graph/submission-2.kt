/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        return bfs(node)
    }

    fun bfs(node: Node): Node {
        val map = mutableMapOf<Int, Node>()
        val queue = ArrayDeque<Node>()

        val newHead = Node(node.`val`)
        queue.addLast(node)
        map[node.`val`] = newHead

        while(queue.isNotEmpty()) {
            val first = queue.removeFirst()
            val newNodeList = ArrayList<Node?>()

            for (eachNode in first.neighbors) {
                eachNode?.let {
                    if (!map.contains(it.`val`)) {
                    val newNode = Node(it.`val`)
                    map[it.`val`] = newNode
                    newNodeList.add(newNode)
                    queue.addLast(eachNode)
                } else {
                    newNodeList.add(map[it.`val`]!!)
                }
                }
            }
            map[first.`val`!!]?.neighbors = newNodeList
            
        }

        return newHead

    }
}
