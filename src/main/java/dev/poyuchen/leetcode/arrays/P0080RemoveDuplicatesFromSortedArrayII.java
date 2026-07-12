/**
 * 80. Remove Duplicates from Sorted Array II
 *
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique
 * element appears at most twice. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be
 * placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first
 * k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1)
 * extra memory.
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
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 *
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in non-decreasing order.
 */
package dev.poyuchen.leetcode.arrays;

import dev.poyuchen.leetcode.common.Checks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class P0080RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int i = 2;

        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public int firstTry(int[] nums) {
        Map<Integer, Integer> keys = new HashMap<>();

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            boolean isExists = keys.containsKey(nums[j]);
            if (!isExists || keys.get(nums[j]) < 2) {
                if (nums[i] != nums[j]) {
                    nums[i] = nums[j];
                }
                i++;
                keys.put(nums[j], isExists ? 2 : 1);
            }
        }
        return i;
    }

    public static void main(String[] args) {
        var solution = new P0080RemoveDuplicatesFromSortedArrayII();

        checkAccepted(solution, new int[]{1, 1, 1, 2, 2, 3}, new int[]{1, 1, 2, 2, 3}, "example 1");
        checkAccepted(
                solution,
                new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3},
                new int[]{0, 0, 1, 1, 2, 3, 3},
                "example 2"
        );
        checkAccepted(solution, new int[]{1}, new int[]{1}, "single element");
        checkAccepted(solution, new int[]{1, 1}, new int[]{1, 1}, "two same values");
        checkAccepted(solution, new int[]{1, 1, 1, 1}, new int[]{1, 1}, "more than two same values");
        checkAccepted(solution, new int[]{1, 2, 3}, new int[]{1, 2, 3}, "no duplicates");
        checkAccepted(solution, new int[]{1, 1, 1, 2, 2, 2, 3, 3}, new int[]{1, 1, 2, 2, 3, 3}, "example 1");

        checkAccepted(
                solution,
                new int[]{0, 0, 1, 1, 1, 1, 2, 2, 2, 4},
                new int[]{0, 0, 1, 1, 2, 2, 4},
                "example 2"
        );
        checkAccepted(
                solution,
                new int[]{0,1,2,2,2,2,2,3,4,4,4},
                new int[]{0,1,2,2,3,4,4},
                "example 2"
        );
        System.out.println("P0080RemoveDuplicatesFromSortedArrayII checks passed.");
    }

    private static void checkAccepted(
            P0080RemoveDuplicatesFromSortedArrayII solution,
            int[] nums,
            int[] expectedNums,
            String message
    ) {
        int k = solution.removeDuplicates(nums);
        Checks.checkEquals(expectedNums.length, k, message + " length");
        Checks.checkArrayEquals(expectedNums, Arrays.copyOf(nums, k), message + " values");
    }
}
