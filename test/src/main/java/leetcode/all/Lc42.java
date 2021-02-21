package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/27 20:07
 */
public class Lc42 {
	public static void main(String[] args) {
		Lc42 lc42 = new Lc42();
		lc42.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
	}

	public int trap(int[] height) {
		if (height.length < 2) {
			return 0;
		}
		int iMax = height[0];
		int jMax = height[height.length - 1];
		int result = 0;
		for (int i = 0, j = height.length - 1; i < j; ) {
			int now;
			if (iMax < jMax) {
				i++;
				iMax = Math.max(iMax, height[i]);
				now = height[i];
			} else {
				j--;
				jMax = Math.max(jMax, height[j]);
				now = height[j];
			}
			int dec = Math.min(iMax, jMax) - now;
			if (dec <= 0) {
				continue;
			}
			result += dec;
		}
		return result;
	}
}
