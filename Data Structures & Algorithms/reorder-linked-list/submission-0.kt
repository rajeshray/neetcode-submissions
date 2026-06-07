/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var slow = head
        var fast = head

        while(fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        var prev: ListNode? = null
        var current = slow

        while(current != null) {
            val next = current?.next
            current?.next = prev
            prev = current
            current = next
        }

        var first = head
        var second = prev

        while (first != null) {
            val firstNext = first?.next
            val secondNext = second?.next

            first?.next = second
            first = firstNext

            second?.next = first
            second = secondNext
            
        }


    }
}
