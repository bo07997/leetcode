package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/6/13 17:17
 */
public class Lc540 {
	public static void main(String[] args) {
		Boolean[] tes = new Boolean[5];

	}

	public int singleNonDuplicate(int[] nums) {
		int result = 0;
		for (int i : nums) {
			result ^= i;
		}
		return result;
	}
}
