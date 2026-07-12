/**
 * 189. Rotate Array
 *
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 *
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 *
 * Follow up: Could you do it in-place with O(1) extra space?
 */
package dev.poyuchen.leetcode.arrays;

import dev.poyuchen.leetcode.common.Checks;

public final class P0189RotateArray {
    public void rotate(int[] nums, int k) {
        int steps = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, steps - 1);
        reverse(nums, steps, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public void firstTry(int[] nums, int k) {
        if (nums.length == 1 || k == 0) return;

        int[] back = nums.clone();
        int move = nums.length > k ? nums.length - k : nums.length - k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (move > nums.length - 1) {
                move = 0;
            }

            nums[i] = back[move];
            move++;
        }
    }

    public static void main(String[] args) {
        var solution = new P0189RotateArray();

        checkRotate(solution, new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}, "example 1");
        checkRotate(solution, new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100}, "example 2");
        checkRotate(solution, new int[]{1, 2}, 3, new int[]{2, 1}, "k larger than length");
        checkRotate(solution, new int[]{1, 2, 3}, 0, new int[]{1, 2, 3}, "zero steps");
        checkRotate(solution, new int[]{1}, 10, new int[]{1}, "single element");
        checkRotate(solution, new int[]{1, 2}, 4, new int[]{1, 2}, "k larger than length");
        checkRotate(solution, new int[]{1, 2, 3}, 4, new int[]{3, 1, 2}, "k larger than length");

        System.out.println("P0189RotateArray checks passed.");
    }

    private static void checkRotate(P0189RotateArray solution, int[] nums, int k, int[] expected, String message) {
        solution.rotate(nums, k);
        Checks.checkArrayEquals(expected, nums, message);
    }
}
