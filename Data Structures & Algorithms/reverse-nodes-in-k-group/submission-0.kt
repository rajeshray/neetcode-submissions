/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {

        var count = head

        for (i in 0 until k) {
            if (count == null) return head
            count = count.next
        }


        var prev: ListNode? = null
        var current = head
        for (i in 0 until k) {
            val next = current?.next
            current?.next = prev
            prev = current
            current = next
        }

        head?.next = reverseKGroup(current, k)

        return prev

    }
}
