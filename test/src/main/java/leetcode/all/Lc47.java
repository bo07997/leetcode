package leetcode.all;

import java.util.*;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/30 16:47
 */
public class Lc47 {
	public static void main(String[] args) {
		Lc47 lc47 = new Lc47();
		System.out.println(lc47.permute(new int[] { 1, 1, 2 }));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		Deque<Integer> path = new ArrayDeque<>(nums.length);
		dfs(result, nums, 0, path, used);
		return result;
	}

	public void dfs(List<List<Integer>> result, int[] nums, int depth, Deque<Integer> path,
			boolean[] used) {
		if (nums.length == depth) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			used[i] = true;
			path.addLast(nums[i]);
			dfs(result, nums, depth + 1, path, used);
			used[i] = false;
			path.removeLast();
		}
	}
}
