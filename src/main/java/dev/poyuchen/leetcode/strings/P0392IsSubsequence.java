/**
 * 392. Is Subsequence
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence is formed by deleting some characters without disturbing the relative positions of the remaining
 * characters.
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * s and t consist only of lowercase English letters.
 */
package dev.poyuchen.leetcode.strings;

import dev.poyuchen.leetcode.common.Checks;

public final class P0392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;

        for (int tIndex = 0; tIndex < t.length() && sIndex < s.length(); tIndex++) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
        }

        return sIndex == s.length();
    }

    public boolean firstTry(String s, String t) {
        int matchCounts = 0;
        int i = 0, j = 0;
        for (; i < s.length(); i++) {
            for (; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    matchCounts++;
                    j++;
                    break;
                }
            }
        }
        return matchCounts == s.length();
    }

    public static void main(String[] args) {
        var solution = new P0392IsSubsequence();

        Checks.check(solution.isSubsequence("abc", "ahbgdc"), "example 1");
        Checks.check(!solution.isSubsequence("axc", "ahbgdc"), "example 2");
        Checks.check(solution.isSubsequence("", "ahbgdc"), "empty s");
        Checks.check(!solution.isSubsequence("a", ""), "empty t");
        Checks.check(solution.isSubsequence("ace", "abcde"), "skip characters");

        System.out.println("P0392IsSubsequence checks passed.");
    }
}

