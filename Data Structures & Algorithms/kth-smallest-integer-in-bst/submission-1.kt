/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var kthSmall = 0
    var count = 0
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        depth(root, k)
        return kthSmall
    }

    fun depth(root: TreeNode?, k: Int) {
        if (root == null) return
        depth(root?.left, k)

        count++

        if (count == k) {
            kthSmall = root.`val`
            return
        }
        
        depth(root?.right, k)
    }
}
