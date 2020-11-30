package leetcode.DP;

public class lc121 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int max = 0;
        for (int i=1;i<prices.length;i++){
            if (prices[i] - prices[0] > max ){
                max = prices[i] - prices[0];
            }
            if (prices[i]<prices[0]){
                prices[0] = prices[i];
            }
        }
        return max;
    }
}
