package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/12/12 15:40
 * 53. 最大子序和 简单
 */
public class Lc53 {

	public static void main(String[] args) {
		Lc53 lc51 = new Lc53();
		System.out.println(lc51.maxSubArray(new int[] { 1, 2, -1 }));
	}

	public int maxSubArray(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int curResult = nums[0];
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (curResult > 0) {
				curResult += nums[i];
			} else {
				curResult = nums[i];
			}
			if (curResult > result) {
				result = curResult;
			}
		}
		return result;
	}
}
