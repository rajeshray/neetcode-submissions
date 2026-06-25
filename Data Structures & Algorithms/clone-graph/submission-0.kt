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
        val visited = mutableSetOf<Int>()
        val queue = ArrayDeque<Node>()

        val newHead = Node(node.`val`)
        map[node.`val`] = newHead
        visited.add(node.`val`)
        queue.addLast(node)

        while(queue.isNotEmpty()) {
            val first = queue.removeFirst()
            val newNodeList = mutableListOf<Node?>()

            for (eachNode in first.neighbors) {
                eachNode?.let {
                    if (!visited.contains(it.`val`)) {
                    visited.add(it.`val`)
                    val newNode = Node(it.`val`)
                    map[it.`val`] = newNode
                    newNodeList.add(newNode)
                    queue.addLast(eachNode)
                } else {
                    newNodeList.add(map[it.`val`]!!)
                }
                }
            }
            map[first.`val`!!]?.neighbors = newNodeList as ArrayList
            
        }

        return newHead

    }
}
