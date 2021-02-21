package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/30 16:47
 */
public class Lc121 {
	public static void main(String[] args) {
		Lc121 lc121 = new Lc121();
		System.out.println(lc121.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	}

	/**
	 * 状态转移
	 * 天数 次数 状态
	 */
	public int maxProfit(int[] prices) {
		int dp_i_0 = 0;
		int dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, -prices[i]);
		}
		return dp_i_0;
	}
}
