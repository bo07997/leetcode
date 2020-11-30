package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/23 10:40
 */
public class Lc34 {
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[] { -1, -1 };
		}
		int indexLeft = searchIndex(nums, 0, nums.length - 1, target, true);
		if (indexLeft == -1) {
			return new int[] { -1, -1 };
		}
		return new int[] { indexLeft, searchIndex(nums, indexLeft, nums.length - 1, target, false) };
	}

	public int searchIndex(int[] nums, int begin, int end, int target, boolean isLeft) {
		if (begin > end) {
			return -1;
		}
		int middle = begin + (end - begin) / 2;
		if (nums[middle] < target || (middle + 1 <= end && nums[middle + 1] == target && !isLeft)) {
			return searchIndex(nums, middle + 1, end, target, isLeft);
		}
		if (nums[middle] > target || (middle - 1 >= begin && nums[middle - 1] == target && isLeft)) {
			return searchIndex(nums, begin, middle - 1, target, isLeft);
		}
		return middle;
	}
}
