/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        val visitedSet = mutableSetOf<ListNode>()

        var current = head
        while(current != null) {
            if (visitedSet.contains(current!!)) {
                return true
            } else {
                visitedSet.add(current!!)
            }
            current = current?.next
        }

        return false

    }
}
