package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/30 16:47
 * 冷冻期1天
 */
public class Lc309 {
	public static void main(String[] args) {
		Lc309 lc121 = new Lc309();
		System.out.println(lc121.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

	/**
	 * 状态转移
	 * 天数 次数 状态
	 */
	public int maxProfit(int[] prices) {
		int dp_i_0 = 0;
		int dp_i_1 = Integer.MIN_VALUE;
		// 代表 dp[i-2][0]
		int dp_pre_0 = 0;
		for (int i = 0; i < prices.length; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
			dp_pre_0 = temp;
		}
		return dp_i_0;
	}
}
