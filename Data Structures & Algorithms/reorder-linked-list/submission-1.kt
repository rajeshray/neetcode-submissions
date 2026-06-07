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

        while(fast?.next?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        var prev: ListNode? = null
        var secondHead = slow?.next
        slow?.next = null

        var current = secondHead

        while(current != null) {
            val next = current?.next
            current?.next = prev
            prev = current
            current = next
        }

        var first = head
        var second = prev

        while (second != null) {
            val firstNext = first?.next
            val secondNext = second.next

            first?.next = second
            second.next = firstNext

            first = firstNext
            second = secondNext
            
        }


    }
}
