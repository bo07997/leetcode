package leetcode.DP;

import java.util.stream.IntStream;

public class lc309 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,4,1}));
    }
    public static int maxProfit( int[] prices) {
        if (prices.length == 0) return 0;
        // 在第i天所能获得的最大收益
        // profit[][0]: 表示未持有股票
        // profit[][1]: 表示持有股票
        // profit[][2]: 表示冷冻期
        int[][] profits = new int[prices.length][3];

        // 初始化
        profits[0][0] = 0;
        profits[0][1] = - prices[0];
        profits[0][2] = 0;

        for (int i = 1; i < prices.length; ++i) {
            profits[i][0] = Math.max(profits[i-1][0], // 不操作
                    profits[i-1][2] // 解除冷冻期
            );
            profits[i][1] = Math.max(profits[i-1][1], // 继续持有股票
                    profits[i-1][0] - prices[i] // 买入股票
            );
            profits[i][2] = Math.max(0,
                    profits[i-1][1] + prices[i] // 卖出股票
            );
        }
        return Math.max(profits[prices.length-1][0], profits[prices.length-1][2]);

    }
}
