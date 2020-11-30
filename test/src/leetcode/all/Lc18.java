package leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/10 20:09
 */
public class Lc18 {

	public static void main(String[] args) {
		//		int[] test = new int[] { -3, -1, 0, 2, 4, 5 };
		//		threeSum(test, 2);
		ConcurrentLinkedQueue test = new ConcurrentLinkedQueue();
	}

	public static List<List<Integer>> threeSum(int[] nums, int target) {
		Arrays.sort(nums);
		if (nums.length < 3) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
						while (left < right && nums[left] == nums[left + 1]) {
							left++;
						}
						while (left < right && nums[right] == nums[right - 1]) {
							right--;
						}
						result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						left++;
						right--;
					} else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
						left++;
					} else {
						right--;
					}
				}
				while (j < nums.length - 2 && nums[j] == nums[j + 1]) {
					j++;
				}
			}
			while (i < nums.length - 3 && nums[i] == nums[i + 1]) {
				i++;
			}
		}
		return result;
	}
}
