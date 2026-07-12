/**
 * 121. Best Time to Buy and Sell Stock
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Choose one day to buy and one later day to sell. Return the maximum profit. If no profit is possible, return 0.
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 *
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 *
 * Constraints:
 *
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 */
package dev.poyuchen.leetcode.arrays;

import dev.poyuchen.leetcode.common.Checks;

public final class P0121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - minPrice);
            minPrice = Math.min(prices[i], minPrice);
        }

        return profit;
    }

    // public int maxProfit(int[] prices) {
    //     int minPrice = prices[0];
    //     int bestProfit = 0;

    //     for (int price : prices) {
    //         minPrice = Math.min(minPrice, price);
    //         bestProfit = Math.max(bestProfit, price - minPrice);
    //     }

    //     return bestProfit;
    // }

    public static void main(String[] args) {
        var solution = new P0121BestTimeToBuyAndSellStock();

        Checks.checkEquals(5, solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), "example 1");
        Checks.checkEquals(0, solution.maxProfit(new int[]{7, 6, 4, 3, 1}), "example 2");
        Checks.checkEquals(0, solution.maxProfit(new int[]{1}), "single day");
        Checks.checkEquals(4, solution.maxProfit(new int[]{1, 2, 3, 4, 5}), "always increasing");

        System.out.println("P0121BestTimeToBuyAndSellStock checks passed.");
    }
}
