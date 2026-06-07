/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        var current = head
        val lookup = HashMap<Node, Node?>()

        while(current != null) {
            val copy = lookup.getOrPut(current) {
                Node(current.`val`)
            }
             current.next?.let {
                copy?.next = lookup.getOrPut(it) { Node(it.`val`) }
            }

            current.random?.let {
                copy?.random = lookup.getOrPut(it) { Node(it.`val`) }
            }

            current = current?.next
           
        }

        return lookup[head]

    }
}
