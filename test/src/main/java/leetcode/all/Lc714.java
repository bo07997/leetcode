package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/30 16:47
 */
public class Lc714 {
	public static void main(String[] args) {
		Lc714 lc121 = new Lc714();
		System.out.println(lc121.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }, 5));
	}

	/**
	 * 状态转移
	 * 天数 次数 状态
	 */
	public int maxProfit(int[] prices, int fee) {
		int dp_i_0 = 0;
		int dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
		}
		return dp_i_0;
	}
}
