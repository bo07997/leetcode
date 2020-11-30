package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/22 20:16
 */
public class Lc32 {
	public static void main(String[] args) {
		Lc32 test = new Lc32();
		test.longestValidParentheses("()(())");
	}

	public int longestValidParentheses(String s) {
		int[] dp = new int[s.length()];
		int max = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == '(' && s.charAt(i) == ')') {
				dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
			} else if (s.charAt(i) == ')' && dp[i - 1] != 0 && i - 1 - dp[i - 1] >= 0
					&& s.charAt(i - 1 - dp[i - 1]) == '(') {
				if (dp[i] < dp[i - 1] + 2) {
					dp[i] = dp[i - 1] + 2;
					if (i - 1 - dp[i - 1] - 1 >= 0) {
						dp[i] += dp[i - 1 - dp[i - 1] - 1];
					}
				}
			}
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		return max;
	}
}
