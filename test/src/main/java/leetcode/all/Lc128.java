package leetcode.all;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/30 16:47
 */
public class Lc128 {
	public static void main(String[] args) {
		Lc128 lc46 = new Lc128();
		System.out.println(lc46.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
	}

	public int lengthOfLIS(int[] nums) {
		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i] - 1)) {
				continue;
			}
			int first = nums[i];
			for (; ; ) {
				if (!set.contains(first)) {
					break;
				}
				max = Math.max(max, first - nums[i] + 1);
				first++;
			}
		}
		return max;
	}

}
