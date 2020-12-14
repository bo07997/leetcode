package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/27 20:49
 */
public class Lc27 {

	public int removeElement(int[] nums, int val) {
		int i = 0;
		int j = 0;
		for (; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i++] = nums[j];
			}
		}
		return i;
	}
}
