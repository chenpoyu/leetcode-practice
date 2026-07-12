/**
 * 169. Majority Element
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than floor(n / 2) times. You may assume that the majority
 * element always exists in the array.
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * The input is generated such that a majority element will exist in the array.
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
package dev.poyuchen.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

import dev.poyuchen.leetcode.common.Checks;

public final class P0169MajorityElement {
    public int majorityElement(int[] nums) {
        int times = (int) Math.floor(nums.length / 2);
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            int add = (count.containsKey(i) ? count.get(i) : 0) + 1;
            if (add > times) return i;
            count.put(i, add);
        }
        return 0;
    }

    public static void main(String[] args) {
        var solution = new P0169MajorityElement();

        Checks.checkEquals(3, solution.majorityElement(new int[]{3, 2, 3}), "example 1");
        Checks.checkEquals(2, solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}), "example 2");
        Checks.checkEquals(1, solution.majorityElement(new int[]{1}), "single element");
        Checks.checkEquals(-1, solution.majorityElement(new int[]{-1, -1, -1, 2, 3}), "negative number");

        System.out.println("P0169MajorityElement checks passed.");
    }
}
