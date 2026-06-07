/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root?.left == null && root?.right == null) {
            return root
        }
        val tempLeft = root?.left
        val tempRight = root?.right
        root?.left = tempRight
        root?.right = tempLeft

        invertTree(root?.left)
        invertTree(root?.right)

        return root
    }
}
