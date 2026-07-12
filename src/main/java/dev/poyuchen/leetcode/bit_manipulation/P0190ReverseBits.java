/**
 * 190. Reverse Bits
 *
 * Reverse bits of a given 32 bits signed integer.
 *
 * Example 1:
 *
 * Input: n = 43261596
 *
 * Output: 964176192
 *
 * Explanation:
 *
 * Integer  Binary
 * 43261596 00000010100101000001111010011100
 * 964176192 00111001011110000010100101000000
 *
 * Example 2:
 *
 * Input: n = 2147483644
 *
 * Output: 1073741822
 *
 * Explanation:
 *
 * Integer  Binary
 * 2147483644 01111111111111111111111111111100
 * 1073741822 00111111111111111111111111111110
 *
 * Constraints:
 *
 * 0 <= n <= 2^31 - 2
 * n is even.
 *
 * Follow up: If this function is called many times, how would you optimize it?
 */
package dev.poyuchen.leetcode.bit_manipulation;

import dev.poyuchen.leetcode.common.Checks;

public final class P0190ReverseBits {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= n & 1;
            n >>>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        var solution = new P0190ReverseBits();

        Checks.checkEquals(964176192, solution.reverseBits(43261596), "example 1");
        Checks.checkEquals(1073741822, solution.reverseBits(2147483644), "example 2");
        Checks.checkEquals(0, solution.reverseBits(0), "zero");

        System.out.println("P0190ReverseBits checks passed.");
    }
}
