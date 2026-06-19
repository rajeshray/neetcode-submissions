/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        if (lists.size == 1) return lists[0]

        var head = ListNode(0)

        for (i in lists.indices) {
            if (i == 0) continue
            lists[i] = mergeTwoList(head, lists[i-1], lists[i])
        }

        return lists[lists.size - 1]
    
    }


    fun mergeTwoList(head: ListNode, node1: ListNode?, node2: ListNode?): ListNode {
        val headNode = head
        var newList = head
        var list1Curr = node1
        var list2Curr = node2


        while(list1Curr != null && list2Curr != null) {
            if (list1Curr.`val` < list2Curr.`val`) {
                newList?.next = list1Curr
                list1Curr = list1Curr?.next
            } else {
                newList?.next = list2Curr
                list2Curr = list2Curr?.next
            }
             newList = newList.next!!
        }

        newList?.next = list1Curr ?: list2Curr

        return headNode?.next!!


    }
}
