/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {

        if (lists.isEmpty()) return null

        var result = lists[0]

        for (i in 1 until lists.size) {
            result = mergeTwoList(result, lists[i])
        }

        return result
    
    }


    fun mergeTwoList(node1: ListNode?, node2: ListNode?): ListNode? {
        val headNode = ListNode(0)
        var newList = headNode
        var list1Curr = node1
        var list2Curr = node2


        while(list1Curr != null && list2Curr != null) {
            if (list1Curr.`val` < list2Curr.`val`) {
                newList?.next = list1Curr
                list1Curr = list1Curr.next
            } else {
                newList?.next = list2Curr
                list2Curr = list2Curr.next
            }
             newList = newList.next!!
        }

        newList?.next = list1Curr ?: list2Curr

        return headNode?.next


    }
}
