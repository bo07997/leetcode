package leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/2 18:16
 */
public class lc15 {
	public static void main(String[] args) {
		int[] test = new int[] { 0, 0, 0 };
		threeSum(test);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		if (nums.length < 2) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			if (nums[i] > 0) {
				break;
			}
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] == 0) {
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
				} else if (nums[i] + nums[left] + nums[right] < 0) {
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
