package leetcode.DP;

import java.util.Arrays;
import java.util.Comparator;

public class lc123 {
    public static void main(String[] args) {
        int num =5;
        num = (int) Math.ceil(num * 0.9);// 热更
        System.out.println(num);
    }
    public  int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // dp[i][j] ，表示 [0, i] 区间里，状态为 j 的最大收益
        // j = 0：什么都不操作
        // j = 1：第 1 次买入一支股票
        // j = 2：第 1 次卖出一支股票
        // j = 3：第 2 次买入一支股票
        // j = 4：第 2 次卖出一支股票

        int[] dp = new int[5];
        dp[1] = -prices[0];
        // 3 状态都还没有发生，因此应该赋值为一个不可能的数
        dp[3] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            dp[0] = 0;
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
        }
        return Math.max(0, Math.max(dp[2], dp[4]));

    }

    //内存超出
    public static int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int[][] max = new int[prices.length][prices.length];
        int[][] result = new int[prices.length][prices.length];
        for(int j = 0;j<prices.length;j++){
            max[j][j] = prices[j];
            for (int i = 0;i<j;i++){
                if(max[i][j-1]<prices[j]){
                    max[i][j] = prices[j];
                    result[i][j] = result[i][j-1] + (prices[j] - max[i][j-1]);
                } else {
                    max[i][j] = max[i][j-1];
                    result[i][j] = result[i][j-1];
                }
            }
        }
        int maxNum = 0;
        //搜寻
        for(int j = 0;j<prices.length;j++){
            for (int i=1;i<prices.length;i++){
                int tempNum = result[j][i] + ((i+1)>=prices.length?0:result[i+1][prices.length - 1]);
                int tempNum2 = result[j][i-1] + result[i][prices.length - 1];
                maxNum = Math.max(Math.max(maxNum,tempNum),tempNum2);
            }
        }
        return  maxNum;
    }
    //错误做法
//    public static int maxProfit(int[] prices) {
//        if (prices.length < 2){
//            return 0;
//        }
//        int[] result = new int[prices.length];
//        int buy = prices[0];
//        int max = 0;
//        for (int i = 1;i<prices.length;i++){
//            if (prices[i]-buy<max){
//                result[i - 1] = max;
//                buy = prices[i];
//                max = 0;
//            } else if(i == prices.length - 1){
//                result[i] += prices[i] - buy;
//            }
//            else {
//                max = prices[i] - buy;
//            }
//        }
//        return Arrays.stream(result).map(i -> -i).sorted().map(i -> -i).limit(2).sum();
//    }
}
