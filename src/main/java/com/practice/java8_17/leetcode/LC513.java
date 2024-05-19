package com.practice.java8_17.leetcode;
//Given the root of a binary tree, return the leftmost value in the last row of
//the tree.
//
//
// Example 1:
//
//
//Input: root = [2,1,3]
//Output: 1
//
//
// Example 2:
//
//
//Input: root = [1,2,3,4,null,5,6,null,null,7]
//Output: 7
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 10⁴].
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 35
//06 👎 278


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class LC513 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
    }

    public int findBottomLeftValue(TreeNode root) {
        int lhs = Integer.MIN_VALUE;
        int tempLhs = traverseLeft(root);
        if (tempLhs > lhs) {
            lhs = tempLhs;
        }
        return lhs;
    }

    private int traverseLeft(TreeNode root) {
        if (root == null) return 0;
        else {
            if (root.left == null) {
                return root.val;
            } else {
                return traverseLeft(root.left);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
