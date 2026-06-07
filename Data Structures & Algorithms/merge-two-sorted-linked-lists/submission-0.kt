/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var dummyNode: ListNode? = ListNode(-1)
        var firstList = list1
        var secondList = list2
        val headNode = dummyNode

        while(firstList != null && secondList != null) {
            if (firstList!!.`val` <= secondList!!.`val`) {
                dummyNode?.next = firstList
                firstList = firstList?.next
            } else {
                dummyNode?.next = secondList
                secondList = secondList?.next
            }
            dummyNode = dummyNode?.next
        }

        while(firstList != null) {
            dummyNode?.next = firstList
            firstList = firstList?.next
            dummyNode = dummyNode?.next
        }

        while(secondList != null) {
            dummyNode?.next = secondList
            secondList = secondList?.next
            dummyNode = dummyNode?.next
        }

        
        return headNode?.next

    }
}
