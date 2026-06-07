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
        depth(root, 0)
        return finalList
    }

    fun depth(root: TreeNode?, index: Int) {
        if (root == null) return
        if (finalList.size <= index) {
            finalList.add(mutableListOf())
        }
        finalList[index].add(root.`val`)
        depth(root?.left, index + 1)
        depth(root?.right, index + 1)

    }
}
