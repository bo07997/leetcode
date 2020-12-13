package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/30 16:47
 */
public class Lc46 {
	public static void main(String[] args) {
		Lc46 lc46 = new Lc46();
		System.out.println(lc46.permute(new int[] { 1, 1, 3 }));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0) {
			return result;
		}
		return permute(nums, 0);
	}

	public List<List<Integer>> permute(int[] nums, int index) {
		List<List<Integer>> tempResult = new ArrayList<>();
		if (index == nums.length - 1) {
			List<Integer> temp = new ArrayList<>();
			temp.add(nums[index]);
			tempResult.add(temp);
			return tempResult;
		}

		List<List<Integer>> lastResult = permute(nums, index + 1);
		for (int i = 0; i < lastResult.size(); i++) {
			for (int j = 0; j <= lastResult.get(i).size(); j++) {
				List<Integer> temp = new ArrayList<>(lastResult.get(i));
				temp.add(j, nums[index]);
				tempResult.add(temp);
			}

		}
		return tempResult;
	}
}
