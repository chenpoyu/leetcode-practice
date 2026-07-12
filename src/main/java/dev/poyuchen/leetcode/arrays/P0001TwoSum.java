package dev.poyuchen.leetcode.arrays;

import dev.poyuchen.leetcode.common.Checks;

import java.util.HashMap;

public final class P0001TwoSum {
    public int[] twoSum(int[] nums, int target) {
        var seen = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        var solution = new P0001TwoSum();

        Checks.checkArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{2, 7, 11, 15}, 9), "example 1");
        Checks.checkArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{3, 2, 4}, 6), "example 2");
        Checks.checkArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{3, 3}, 6), "example 3");

        System.out.println("P0001TwoSum checks passed.");
    }
}
