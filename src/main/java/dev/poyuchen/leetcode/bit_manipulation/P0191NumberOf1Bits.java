/**
 * 191. Number of 1 Bits
 *
 * Given a positive integer n, write a function that returns the number of set bits in its binary representation
 * (also known as the Hamming weight).
 *
 * Example 1:
 *
 * Input: n = 11
 *
 * Output: 3
 *
 * Explanation:
 *
 * The input binary string 1011 has a total of three set bits.
 *
 * Example 2:
 *
 * Input: n = 128
 *
 * Output: 1
 *
 * Explanation:
 *
 * The input binary string 10000000 has a total of one set bit.
 *
 * Example 3:
 *
 * Input: n = 2147483645
 *
 * Output: 30
 *
 * Explanation:
 *
 * The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
 *
 * Constraints:
 *
 * 1 <= n <= 2^31 - 1
 *
 * Follow up: If this function is called many times, how would you optimize it?
 */
package dev.poyuchen.leetcode.bit_manipulation;

import dev.poyuchen.leetcode.common.Checks;

public final class P0191NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n &= n - 1;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        var solution = new P0191NumberOf1Bits();

        Checks.checkEquals(3, solution.hammingWeight(11), "example 1");
        Checks.checkEquals(1, solution.hammingWeight(128), "example 2");
        Checks.checkEquals(30, solution.hammingWeight(2147483645), "example 3");
        Checks.checkEquals(1, solution.hammingWeight(1), "one");

        System.out.println("P0191NumberOf1Bits checks passed.");
    }
}
