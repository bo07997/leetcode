package leetcode.DP.other;

import java.util.stream.IntStream;

/**
 * @author ldb
 * @Package leetcode.DP.other
 * @date 2020/5/31 19:24
 * 面试题 17.21. 直方图的水量
 */
public class O1 {

	public static void main(String[] args) {
		//		trap2(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
		System.out.println(IntStream.rangeClosed(0, 10).skip(11).findFirst().getAsInt());
	}

	/**
	 * 解法1 DP(O(n),O(n))
	 *
	 * @param height height
	 * @return int
	 */
	public static int trap(int[] height) {
		int[] dp = new int[height.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			if (height[i] > max) {
				max = height[i];
			}
			dp[i] = max;
		}
		max = Integer.MIN_VALUE;
		int result = 0;
		for (int j = dp.length - 1; j >= 0; j--) {
			if (height[j] > max) {
				max = height[j];
			}
			result += Math.max(0, Math.min(max - height[j], dp[j] - height[j]));
		}
		return result;
	}

	/**
	 * 解法2 双指针(O(n),1)
	 *
	 * @param height height
	 * @return int
	 */
	public static int trap2(int[] height) {
		int i = 0;
		int j = height.length - 1;
		if (height.length == 0) {
			return 0;
		}
		int imax = height[0];
		int jmax = height[height.length - 1];
		int result = 0;
		while (i < j) {
			if (imax > jmax) {
				j--;
				if (i >= j) {
					break;
				}
				result += Math.max(0, jmax - height[j]);
				jmax = Math.max(jmax, height[j]);
			} else {
				i++;
				if (i >= j) {
					break;
				}
				result += Math.max(0, imax - height[i]);
				imax = Math.max(imax, height[i]);
			}
		}
		return result;
	}

}
