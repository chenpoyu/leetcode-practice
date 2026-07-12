/**
 * 383. Ransom Note
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from
 * magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 *
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 *
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote and magazine consist of lowercase English letters.
 */
package dev.poyuchen.leetcode.strings;

import dev.poyuchen.leetcode.common.Checks;

public final class P0383RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            counts[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            counts[index]--;
            if (counts[index] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        var solution = new P0383RansomNote();

        Checks.check(!solution.canConstruct("a", "b"), "example 1");
        Checks.check(!solution.canConstruct("aa", "ab"), "example 2");
        Checks.check(solution.canConstruct("aa", "aab"), "example 3");
        Checks.check(solution.canConstruct("abc", "cbad"), "enough letters");

        System.out.println("P0383RansomNote checks passed.");
    }
}
