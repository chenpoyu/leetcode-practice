/**
 * 55. Jump Game
 *
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in
 * the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 10^5
 */
package dev.poyuchen.leetcode.arrays;

import dev.poyuchen.leetcode.common.Checks;

public final class P0055JumpGame {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }

            farthest = Math.max(farthest, i + nums[i]);

            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        var solution = new P0055JumpGame();

        Checks.check(solution.canJump(new int[]{2, 3, 1, 1, 4}), "example 1");
        Checks.check(!solution.canJump(new int[]{3, 2, 1, 0, 4}), "example 2");
        Checks.check(solution.canJump(new int[]{0}), "single element");
        Checks.check(solution.canJump(new int[]{2, 0, 0}), "exact reach");
        Checks.check(!solution.canJump(new int[]{0, 1}), "blocked at start");

        System.out.println("P0055JumpGame checks passed.");
    }
}
