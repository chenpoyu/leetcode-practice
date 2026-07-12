/**
 * 26. Remove Duplicates from Sorted Array
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
 * element appears only once. The relative order of the elements should be kept the same.
 *
 * Consider the number of unique elements in nums to be k. After removing duplicates, return the number of unique
 * elements k.
 *
 * The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond
 * index k - 1 can be ignored.
 *
 * Custom Judge:
 *
 * int[] nums = [...];
 * int[] expectedNums = [...];
 *
 * int k = removeDuplicates(nums);
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 *
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10^4
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 */
package dev.poyuchen.leetcode.arrays;

import dev.poyuchen.leetcode.common.Checks;

import java.util.Arrays;

public final class P0026RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return nums.length;

        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i-1] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    // 誤會題目意思了，題目給的array 已經有由小到大排
    public int firstTry(int[] nums) {
        int last = nums.length - 1;
        for (int i = 0; i <= last; i++) {
            for (int j = i + 1; j <= last; j++) {
                if (nums[i] == nums[j]) {
                    int tmp = nums[last];
                    nums[last] = nums[j];
                    nums[j] = tmp;
                    j--;
                    last--;
                } else if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i--;
                    break;
                }
            }
        }
        return last + 1;
    }

    public static void main(String[] args) {
        var solution = new P0026RemoveDuplicatesFromSortedArray();

        checkAccepted(solution, new int[]{1, 1, 2}, new int[]{1, 2}, "example 1");
        checkAccepted(
                solution,
                new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
                new int[]{0, 1, 2, 3, 4},
                "example 2"
        );
        checkAccepted(solution, new int[]{1}, new int[]{1}, "single element");
        checkAccepted(solution, new int[]{1, 2, 3}, new int[]{1, 2, 3}, "no duplicates");
        checkAccepted(solution, new int[]{2, 2, 2}, new int[]{2}, "all duplicates");

        System.out.println("P0026RemoveDuplicatesFromSortedArray checks passed.");
    }

    private static void checkAccepted(
            P0026RemoveDuplicatesFromSortedArray solution,
            int[] nums,
            int[] expectedNums,
            String message
    ) {
        int k = solution.removeDuplicates(nums);
        Checks.checkEquals(expectedNums.length, k, message + " length");
        Checks.checkArrayEquals(expectedNums, Arrays.copyOf(nums, k), message + " values");
    }
}
