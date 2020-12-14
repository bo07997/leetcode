package leetcode.DP;

/**
 * @author ldb
 * @Package leetcode.DP
 * @date 2020/5/31 17:42
 */
public class lc11 {
	public static void main(String[] args) {
		maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
	}

	public static int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int result = 0;
		while (i < j) {
			int now = (j - i) * Math.min(height[i], height[j]);
			result = result > now ? result : now;
			if (height[i] > height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return result;
	}
}
