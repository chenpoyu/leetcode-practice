/**
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced
 * binary search tree.
 *
 * Example 1:
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in a strictly increasing order.
 */
package dev.poyuchen.leetcode.trees;

import dev.poyuchen.leetcode.common.Checks;
import dev.poyuchen.leetcode.common.TreeNode;

import java.util.ArrayList;

public final class P0108ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        return new TreeNode(
                nums[mid],
                build(nums, left, mid - 1),
                build(nums, mid + 1, right)
        );
    }

    public static void main(String[] args) {
        var solution = new P0108ConvertSortedArrayToBinarySearchTree();

        checkHeightBalancedBst(solution, new int[]{-10, -3, 0, 5, 9}, "example 1");
        checkHeightBalancedBst(solution, new int[]{1, 3}, "example 2");
        checkHeightBalancedBst(solution, new int[]{1}, "single element");
        checkHeightBalancedBst(solution, new int[]{1, 2, 3, 4, 5, 6}, "even length");

        System.out.println("P0108ConvertSortedArrayToBinarySearchTree checks passed.");
    }

    private static void checkHeightBalancedBst(
            P0108ConvertSortedArrayToBinarySearchTree solution,
            int[] nums,
            String message
    ) {
        TreeNode root = solution.sortedArrayToBST(nums);

        var values = new ArrayList<Integer>();
        inorder(root, values);
        var actual = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            actual[i] = values.get(i);
        }

        Checks.checkArrayEquals(nums, actual, message + " inorder");
        Checks.check(balanceHeight(root) >= 0, message + " is height-balanced");
    }

    private static void inorder(TreeNode root, ArrayList<Integer> values) {
        if (root == null) {
            return;
        }

        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }

    private static int balanceHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = balanceHeight(root.left);
        int right = balanceHeight(root.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}
