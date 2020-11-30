package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/22 17:24
 */
public class Lc31 {
	public static void main(String[] args) {
		Lc31 test = new Lc31();
		int[] tt = new int[] { 5, 1, 1 };
		test.nextPermutation(tt);
	}

	public void nextPermutation(int[] nums) {
		if (nums.length == 1) {
			return;
		}
		int maxIndex = nums.length - 1;
		for (int index = nums.length - 2; index >= 0; index--) {
			if (nums[index] >= nums[maxIndex]) {
				maxIndex = index;
			} else {
				int temp = nums.length - 1;
				for (; temp > index; temp--) {
					if (nums[temp] > nums[index]) {
						break;
					}
				}
				swap(nums, index, temp);
				quickSort(nums, index + 1, nums.length - 1);
				return;
			}
		}
		quickSort(nums, 0, nums.length - 1);
	}

	void swap(int[] nums, int i, int j) {
		nums[i] += nums[j];
		nums[j] = nums[i] - nums[j];
		nums[i] = nums[i] - nums[j];
	}

	void quickSort(int[] nums, int i, int j) {
		int f = i;
		int s = j;
		if (i > j) {
			return;
		}
		int pivot = nums[i];
		while (i < j) {
			while (i < j && nums[i] < pivot) {
				i++;
			}
			while (i < j && nums[j] > pivot) {
				j--;
			}
			if ((nums[i] == nums[j]) && (i < j)) {
				i++;
			} else {
				swap(nums, i, j);
			}
		}
		nums[i] = pivot;
		quickSort(nums, f, i - 1);
		quickSort(nums, i + 1, s);
	}

}
