/**
 * 45. Jump Game II
 *
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. Return the minimum number of
 * jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 1000
 * It is guaranteed that you can reach nums[n - 1].
 */
package dev.poyuchen.leetcode.arrays;

import dev.poyuchen.leetcode.common.Checks;

public final class P0045JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int farthest = 0;
        int stepend = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == stepend) {
                stepend = farthest;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        var solution = new P0045JumpGameII();

        Checks.checkEquals(2, solution.jump(new int[]{2, 3, 1, 1, 4}), "example 1");
        Checks.checkEquals(2, solution.jump(new int[]{2, 3, 0, 1, 4}), "example 2");
        Checks.checkEquals(0, solution.jump(new int[]{0}), "already at last index");
        Checks.checkEquals(1, solution.jump(new int[]{1, 2}), "one jump");
        Checks.checkEquals(3, solution.jump(new int[]{1, 1, 1, 1}), "single-step path");
        Checks.checkEquals(0, solution.jump(new int[]{1}), "already at last index");
        Checks.checkEquals(2, solution.jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}), "");

        System.out.println("P0045JumpGameII checks passed.");
    }
}
