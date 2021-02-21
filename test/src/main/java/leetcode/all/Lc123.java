package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/30 16:47
 */
public class Lc123 {
	public static void main(String[] args) {
		String s = "1";
		Lc123 lc121 = new Lc123();
		System.out.println(lc121.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

	/**
	 * 状态转移
	 * 天数 次数 状态
	 */
	public int maxProfit(int[] prices) {
		int max_k = 2;
		int[][][] dp = new int[prices.length][max_k + 1][2];

		for (int i = 0; i < prices.length; i++) {
			for (int k = max_k; k >= 1; k--) {
				if (i - 1 == -1) {
					dp[i][k][0] = 0;
					dp[i][k][1] = Integer.MIN_VALUE;
					break;
				}
				dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
				dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
			}

		}
		return dp[prices.length - 1][max_k][0];
	}
}
