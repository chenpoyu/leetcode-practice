/**
 * 125. Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
 * non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and
 * numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 10^5
 * s consists only of printable ASCII characters.
 */
package dev.poyuchen.leetcode.strings;

import dev.poyuchen.leetcode.common.Checks;

public final class P0125ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public boolean firstTry(String s) {
        StringBuffer buffer = processString(s);
        int stopAt = (int)Math.floor(buffer.length() / 2);
        for (int startIndex = 0, endIndex = buffer.length() - 1; startIndex < stopAt; startIndex++, endIndex--) {
            if (buffer.charAt(startIndex) != buffer.charAt(endIndex)) {
                return false;
            }
        }

        return true;
    }

    private StringBuffer processString(String s) {
        StringBuffer t = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || Character.isDigit(s.charAt(i))) {
                t.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return t;
    }

    public static void main(String[] args) {
        var solution = new P0125ValidPalindrome();

        Checks.check(solution.isPalindrome("A man, a plan, a canal: Panama"), "example 1");
        Checks.check(!solution.isPalindrome("race a car"), "example 2");
        Checks.check(solution.isPalindrome(" "), "example 3");
        Checks.check(solution.isPalindrome("0P0"), "digits and letters");
        Checks.check(!solution.isPalindrome("0P"), "not palindrome");

        System.out.println("P0125ValidPalindrome checks passed.");
    }
}
