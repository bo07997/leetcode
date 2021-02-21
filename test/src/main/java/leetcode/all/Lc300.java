package leetcode.all;

import java.util.Arrays;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/30 16:47
 */
public class Lc300 {
	public static void main(String[] args) {
		Lc300 lc46 = new Lc300();
		System.out.println(lc46.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
	}

	public int lengthOfLIS(int[] nums) {
		int[] res = new int[nums.length];
		Arrays.fill(res, 1);
		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			int temp = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					temp = Math.max(temp, res[j] + 1);
				}
				res[i] = temp;
				max = Math.max(max, res[i]);
			}

		}
		return max;
	}
}
