/**
 * 530. Minimum Absolute Difference in BST
 *
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two
 * different nodes in the tree.
 *
 * Example 1:
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 10^4].
 * 0 <= Node.val <= 10^5
 */
package dev.poyuchen.leetcode.trees;

import dev.poyuchen.leetcode.common.Checks;
import dev.poyuchen.leetcode.common.TreeNode;

public final class P0530MinimumAbsoluteDifferenceInBST {
    private Integer previous;
    private int minimum;

    public int getMinimumDifference(TreeNode root) {
        previous = null;
        minimum = Integer.MAX_VALUE;
        inorder(root);
        return minimum;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (previous != null) {
            minimum = Math.min(minimum, root.val - previous);
        }
        previous = root.val;
        inorder(root.right);
    }

    public static void main(String[] args) {
        var solution = new P0530MinimumAbsoluteDifferenceInBST();

        Checks.checkEquals(
                1,
                solution.getMinimumDifference(
                        new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6))
                ),
                "example 1"
        );
        Checks.checkEquals(
                1,
                solution.getMinimumDifference(
                        new TreeNode(
                                1,
                                new TreeNode(0),
                                new TreeNode(48, new TreeNode(12), new TreeNode(49))
                        )
                ),
                "example 2"
        );
        Checks.checkEquals(2, solution.getMinimumDifference(new TreeNode(2, new TreeNode(0), null)), "two nodes");

        System.out.println("P0530MinimumAbsoluteDifferenceInBST checks passed.");
    }
}
