/**
 * 100. Same Tree
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Example 1:
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * Example 2:
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 *
 * Example 3:
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 100].
 * -10^4 <= Node.val <= 10^4
 */
package dev.poyuchen.leetcode.trees;

import dev.poyuchen.leetcode.common.Checks;
import dev.poyuchen.leetcode.common.TreeNode;

public final class P0100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        var solution = new P0100SameTree();

        Checks.check(
                solution.isSameTree(
                        new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                        new TreeNode(1, new TreeNode(2), new TreeNode(3))
                ),
                "example 1"
        );
        Checks.check(
                !solution.isSameTree(
                        new TreeNode(1, new TreeNode(2), null),
                        new TreeNode(1, null, new TreeNode(2))
                ),
                "example 2"
        );
        Checks.check(
                !solution.isSameTree(
                        new TreeNode(1, new TreeNode(2), new TreeNode(1)),
                        new TreeNode(1, new TreeNode(1), new TreeNode(2))
                ),
                "example 3"
        );
        Checks.check(solution.isSameTree(null, null), "both empty");

        System.out.println("P0100SameTree checks passed.");
    }
}
