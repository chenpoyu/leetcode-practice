/**
 * 104. Maximum Depth of Binary Tree
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 10^4].
 * -100 <= Node.val <= 100
 */
package dev.poyuchen.leetcode.trees;

import dev.poyuchen.leetcode.common.Checks;
import dev.poyuchen.leetcode.common.TreeNode;

public final class P0104MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        var solution = new P0104MaximumDepthOfBinaryTree();

        var tree = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        Checks.checkEquals(3, solution.maxDepth(tree), "example 1");
        Checks.checkEquals(2, solution.maxDepth(new TreeNode(1, null, new TreeNode(2))), "example 2");
        Checks.checkEquals(0, solution.maxDepth(null), "empty tree");

        System.out.println("P0104MaximumDepthOfBinaryTree checks passed.");
    }
}
