/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * 
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * 
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * Custom Judge:
 * 
 * The judge will test your solution with the following code:
 * 
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 *                             // It is sorted with no values equaling val.
 * 
 * int k = removeElement(nums, val); // Calls your implementation
 * 
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * 
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *  
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
package dev.poyuchen.leetcode.arrays;

import dev.poyuchen.leetcode.common.Checks;

import java.util.Arrays;

public final class P0027RemoveElement {

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    
    // 先求有
    public int firstTry(int[] nums, int val) {
        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }

        if (nums.length == 2) {
            if (nums[0] == val && nums[1] == val) {
                return 0;
            } else if (nums[0] != val && nums[1] != val) {
                return 2;
            } else {
                if (nums[0] == val) {
                    int tmp = nums[0];
                    nums[0] = nums[1];
                    nums[1] = tmp;
                }
                return 1;
            }
        }

        int k = 0;
        int t = nums.length - 1;
        boolean flag = false;
        for (; k <= t; k++) {
            if (nums[k] == val) {
                if (!flag) flag = true;

                boolean flag2 = false;
                for (; t > k; t--) {
                    if (nums[t] != val) {
                        flag2 = true;
                        int tmp = nums[t];
                        nums[t] = nums[k];
                        nums[k] = tmp;
                        break;
                    }
                }

                if (!flag2) {
                    return k;
                }
            }
        }

        if (k == 0 || nums[k - 1] == val) return 0;
        if (!flag) return nums.length;

        return k;
    }

    public static void main(String[] args) {
        var solution = new P0027RemoveElement();

        checkAccepted(solution, new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}, "example 1");
        checkAccepted(solution, new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 0, 1, 3, 4}, "example 2");
        checkAccepted(solution, new int[]{}, 1, new int[]{}, "empty array");
        checkAccepted(solution, new int[]{1, 1, 1}, 1, new int[]{}, "remove all");
        checkAccepted(solution, new int[]{4, 5}, 3, new int[]{4, 5}, "remove none");
        checkAccepted(solution, new int[]{4, 5}, 4, new int[]{5}, "remove one");
        checkAccepted(solution, new int[]{2}, 3, new int[]{2}, "remove none");
        checkAccepted(solution, new int[]{2, 2, 3}, 2, new int[]{3}, "");
        checkAccepted(solution, new int[]{2, 2, 3}, 3, new int[]{2,2}, "");

        System.out.println("P0027RemoveElement checks passed.");
    }

    private static void checkAccepted(
            P0027RemoveElement solution,
            int[] nums,
            int val,
            int[] expectedNums,
            String message
    ) {
        int k = solution.removeElement(nums, val);
        Checks.checkEquals(expectedNums.length, k, message + " length");

        var actualPrefix = Arrays.copyOf(nums, k);
        Arrays.sort(actualPrefix);
        Arrays.sort(expectedNums);

        Checks.checkArrayEquals(expectedNums, actualPrefix, message + " values");
    }
}
