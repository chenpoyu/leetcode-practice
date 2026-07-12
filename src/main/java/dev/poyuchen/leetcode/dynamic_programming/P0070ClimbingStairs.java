/**
 * 70. Climbing Stairs
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
package dev.poyuchen.leetcode.dynamic_programming;

import dev.poyuchen.leetcode.common.Checks;

public final class P0070ClimbingStairs {
    public int climbStairs(int n) {
        int oneStepBefore = 1;
        int twoStepsBefore = 1;

        for (int step = 2; step <= n; step++) {
            int current = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = current;
        }

        return oneStepBefore;
    }

    public static void main(String[] args) {
        var solution = new P0070ClimbingStairs();

        Checks.checkEquals(2, solution.climbStairs(2), "example 1");
        Checks.checkEquals(3, solution.climbStairs(3), "example 2");
        Checks.checkEquals(1, solution.climbStairs(1), "one step");
        Checks.checkEquals(1836311903, solution.climbStairs(45), "max n");

        System.out.println("P0070ClimbingStairs checks passed.");
    }
}
