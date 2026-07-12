/**
 * 88. Merge Sorted Array
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should
 * be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 *
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 *
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: Because m = 0, there are no elements in nums1. The 0 only ensures the merge result can fit.
 *
 * Constraints:
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10^9 <= nums1[i], nums2[j] <= 10^9
 *
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
package dev.poyuchen.leetcode.arrays;

import java.util.Arrays;

import dev.poyuchen.leetcode.common.Checks;

public final class P0088MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int write = m + n - 1;

        while (right >= 0) {
            if (left >= 0 && nums1[left] > nums2[right]) {
                nums1[write] = nums1[left];
                left--;
            } else {
                nums1[write] = nums2[right];
                right--;
            }
            write--;
        }
    }

    // 先求有
    public void firstTry(int[] nums1, int m, int[] nums2, int n) {
        // 將 nums2 放入 nums1
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        // 排序
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        var solution = new P0088MergeSortedArray();

        checkMerge(solution, new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3,
                new int[]{1, 2, 2, 3, 5, 6}, "example 1");
        checkMerge(solution, new int[]{1}, 1, new int[]{}, 0,
                new int[]{1}, "example 2");
        checkMerge(solution, new int[]{0}, 0, new int[]{1}, 1,
                new int[]{1}, "example 3");
        checkMerge(solution, new int[]{2, 0}, 1, new int[]{1}, 1,
                new int[]{1, 2}, "nums2 smaller");
        checkMerge(solution, new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3,
                new int[]{1, 2, 3, 4, 5, 6}, "all nums2 before nums1");

        System.out.println("P0088MergeSortedArray checks passed.");
    }

    private static void checkMerge(
            P0088MergeSortedArray solution,
            int[] nums1,
            int m,
            int[] nums2,
            int n,
            int[] expected,
            String message
    ) {
        solution.merge(nums1, m, nums2, n);
        Checks.checkArrayEquals(expected, nums1, message);
    }
}
