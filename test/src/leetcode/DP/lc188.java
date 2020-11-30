package leetcode.DP;

import java.util.stream.IntStream;

public class lc188 {
    public static void main(String[] args) {
        System.out.println(maxProfit(2,new int[]{2,4,1}));
    }
    public static int maxProfit(int k, int[] prices) {
        if (prices.length == 0||k ==0){
            return 0;
        }
        int[] dp = new int[k*2];
        for (int i = 0;i <dp.length;i+=2){
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = -prices[0];
        for (int i = 1;i<prices.length;i++){
            dp[0] = Math.max(dp[0],-prices[i]);
            dp[1] = Math.max(dp[1],dp[0] + prices[i]);
            for (int index = 2;index<dp.length;index+=2){
                dp[index] = Math.max(dp[index],dp[index - 1] -prices[i]);
                dp[index + 1] = Math.max(dp[index + 1],dp[index] + prices[i]);
            }
        }
        return IntStream.range(0,k).map(i->dp[2*i + 1]).max().getAsInt();
    }
}
