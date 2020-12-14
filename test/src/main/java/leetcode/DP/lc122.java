package leetcode.DP;

import java.util.Arrays;

public class lc122 {
    public static void main(String[] args) {
        maxProfit(new int[]{7,1,5,3,6,4});
    }
    public static int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int buy = prices[0];
        int max = 0;
        int sum = 0;
        prices[0] = 0;
        for (int i = 1;i<prices.length;i++){
            if (prices[i]-buy<max){
                int temp = prices[i];
                sum += max;
                buy = temp;
                max = 0;
            } else if(i == prices.length - 1){
                sum += prices[i] - buy;
            }
            else {
                max = prices[i] - buy;
            }
            prices[i] = 0;
        }
        return sum;
    }
}
