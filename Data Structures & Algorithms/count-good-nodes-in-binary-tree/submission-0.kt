/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var goodNodes = 0
    var currentPathList = mutableListOf<Int>()
    fun goodNodes(root: TreeNode?): Int {
        depth(root)
        return goodNodes
    }

    fun depth(root: TreeNode?) {
        if (root == null) return
        val maxInPath = if (currentPathList.isNotEmpty()) currentPathList.max() else -101
        if (root.`val` >= maxInPath) {
            goodNodes++
        }
        
        currentPathList.add(root.`val`)
        depth(root?.left)
        depth(root?.right)
        if (currentPathList.isNotEmpty()) {
            currentPathList.removeLast()
        }
    }
}
