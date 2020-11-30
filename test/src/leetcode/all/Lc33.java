package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/22 21:08
 */
public class Lc33 {
	public static void main(String[] args) {
		Lc33 test = new Lc33();
		int[] tt = new int[] { 5, 1, 3 };
		System.out.println(test.search(tt, 1));

	}

	public int search(int[] nums, int target) {
		return search(nums, target, 0, nums.length - 1);
	}

	public int search(int[] nums, int target, int begin, int end) {
		if (begin > end || (begin == end && nums[begin] != target)) {
			return -1;
		}
		if (begin == end && nums[begin] == target) {
			return begin;
		}
		int middle = (begin + end) / 2;
		if (nums[middle] >= nums[begin]) {
			if (nums[middle] >= target && nums[begin] <= target) {
				return search(nums, target, begin, middle);
			} else {
				return search(nums, target, middle + 1, end);
			}
		} else {
			if (nums[middle] < target && nums[end] >= target) {
				return search(nums, target, middle + 1, end);
			} else {
				return search(nums, target, begin, middle);
			}
		}
	}
}
