package leetcode.all;

import java.util.Arrays;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/10 19:53
 */
public class Lc16 {
	public static void main(String[] args) {
		int[] test = new int[] { 1, 1, 1, 1 };
		threeSum(test, 0);
	}

	public static int threeSum(int[] nums, int target) {
		Arrays.sort(nums);
		int result = 0;
		int dec = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int newDec = Math.abs(nums[i] + nums[left] + nums[right] - target);
				if (newDec < Math.abs(dec)) {
					dec = newDec;
					result = nums[i] + nums[left] + nums[right];
					if (result == target) {
						return result;
					}
				}
				if (nums[i] + nums[left] + nums[right] < target) {
					left++;
				} else {
					right--;
				}
			}
			while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
				i++;
			}
		}
		return result;
	}
}
