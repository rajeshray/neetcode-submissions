/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>()
        if (root == null) return emptyList()
        queue.addFirst(root) 

        while(queue.isNotEmpty()) {
            val level = queue.size
            var lastNode: TreeNode? = null
            for (i in 0 until level) {
                lastNode = queue.removeLast()
                lastNode?.left?.let {
                    queue.addFirst(it)
                }
                lastNode?.right?.let {
                    queue.addFirst(it)
                }
            }
            lastNode?.let {
                result.add(it.`val`)
            }
        }

        return result

    }
}
