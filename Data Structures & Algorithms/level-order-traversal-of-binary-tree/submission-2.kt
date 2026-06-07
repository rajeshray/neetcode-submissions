/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    val finalList = mutableListOf<MutableList<Int>>()
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        if (root == null) return finalList
        queue.addFirst(Pair(root, 0))
        while(queue.isNotEmpty()) {
            val (node, index) = queue.removeLast()
            if (finalList.size <= index) {
                finalList.add(mutableListOf())
            }
            finalList[index].add(node.`val`)

            if (node?.left != null) {
                 queue.addFirst(Pair(node.left!!, index + 1)) 
            }
            if (node?.right != null) {
                 queue.addFirst(Pair(node.right!!, index + 1)) 
            }
        }

        return finalList
        
    }
}
