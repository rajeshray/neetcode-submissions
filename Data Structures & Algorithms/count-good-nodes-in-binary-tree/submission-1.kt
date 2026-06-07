/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var goodNodes = 0
    fun goodNodes(root: TreeNode?): Int {
        depth(root, Int.MIN_VALUE)
        return goodNodes
    }

    fun depth(root: TreeNode?, maxSoFar: Int) {
        if (root == null) return
        if (root.`val` >= maxSoFar) goodNodes++
        val maxFar = max(maxSoFar, root.`val`)
        depth(root?.left, maxFar)
        depth(root?.right, maxFar)

    }
}
