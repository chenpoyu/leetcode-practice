/**
 * 9. Palindrome Number
 *
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a
 * palindrome.
 *
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Constraints:
 *
 * -2^31 <= x <= 2^31 - 1
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */
package dev.poyuchen.leetcode.math;

import dev.poyuchen.leetcode.common.Checks;

public final class P0009PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }

    public boolean firstTry(int x) {
        if (x < 0) return false;

        char[] str = String.valueOf(x).toCharArray();
        for (int i = 0; i < str.length / 2; i++) {
            if (str[i] != str[str.length - 1 - i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        var solution = new P0009PalindromeNumber();

        Checks.check(solution.isPalindrome(121), "example 1");
        Checks.check(!solution.isPalindrome(-121), "example 2");
        Checks.check(!solution.isPalindrome(10), "example 3");
        Checks.check(solution.isPalindrome(0), "zero");
        Checks.check(solution.isPalindrome(12321), "odd length");

        System.out.println("P0009PalindromeNumber checks passed.");
    }
}
