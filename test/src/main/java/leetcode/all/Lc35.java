package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/23 15:14
 */
public class Lc35 {
	public static void main(String[] args) {
		Lc35 test = new Lc35();
		System.out.println(test.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
	}

	public int searchInsert(int[] nums, int target) {
		return searchIndex(nums, 0, nums.length - 1, target);
	}

	public int searchIndex(int[] nums, int begin, int end, int target) {
		if (begin > end) {
			return begin;
		}
		int middle = begin + (end - begin) / 2;
		if (nums[middle] < target) {
			return searchIndex(nums, middle + 1, end, target);
		}
		if (nums[middle] > target) {
			return searchIndex(nums, begin, middle - 1, target);
		}
		return middle;
	}
}
