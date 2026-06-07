/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carry = 0
        var first = l1
        var second = l2
        var dummy: ListNode? = ListNode(0)
        var newHead: ListNode? = dummy

        while(first != null || second != null) {
            val sum = (first?.`val` ?: 0) + (second?.`val` ?: 0) + carry
            newHead?.next = ListNode(sum%10)
            newHead = newHead?.next
            first = first?.next
            second = second?.next
            carry = sum/10
        }

        if (carry > 0) {
            newHead?.next = ListNode(carry)
            newHead = newHead?.next
        }
        newHead?.next = null

        return dummy?.next


    }
}
