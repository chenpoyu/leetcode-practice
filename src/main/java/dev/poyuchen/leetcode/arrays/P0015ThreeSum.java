/**
 * 15. 3Sum
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and
 * j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 *
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 */
package dev.poyuchen.leetcode.arrays;

import dev.poyuchen.leetcode.common.Checks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class P0015ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var solution = new P0015ThreeSum();

        checkTriplets(
                List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)),
                solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}),
                "example 1"
        );
        checkTriplets(List.of(), solution.threeSum(new int[]{0, 1, 1}), "example 2");
        checkTriplets(List.of(List.of(0, 0, 0)), solution.threeSum(new int[]{0, 0, 0}), "example 3");
        checkTriplets(List.of(List.of(-2, 0, 2)), solution.threeSum(new int[]{-2, 0, 0, 2, 2}), "dedupe");

        System.out.println("P0015ThreeSum checks passed.");
    }

    private static void checkTriplets(List<List<Integer>> expected, List<List<Integer>> actual, String message) {
        Checks.checkEquals(canonical(expected), canonical(actual), message);
    }

    private static List<List<Integer>> canonical(List<List<Integer>> triplets) {
        return triplets.stream()
                .map(triplet -> triplet.stream().sorted().toList())
                .sorted(Comparator
                        .comparing((List<Integer> triplet) -> triplet.get(0))
                        .thenComparing(triplet -> triplet.get(1))
                        .thenComparing(triplet -> triplet.get(2)))
                .toList();
    }
}
