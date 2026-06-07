/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        if (head?.next == null) return null
    
        var slowCount = 1
        var slow = head
        var fast = head

        while(fast?.next?.next != null) {
            fast = fast?.next?.next
            slow = slow?.next
            slowCount++
        }

        val totalCount = if (fast?.next != null)  slowCount * 2 else  (slowCount * 2) - 1

        val removePos = totalCount - n

        println("totalCount = $totalCount, removePos = $removePos")

        if (removePos == 0) return head?.next


        var current = head
        slowCount=1
        while(current != null && slowCount < removePos) {
            current = current?.next
            slowCount++
        }

        current?.next = current?.next?.next

        return head

    }
}
