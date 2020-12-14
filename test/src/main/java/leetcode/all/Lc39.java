package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/28 20:07
 */
public class Lc39 {
	public static void main(String[] args) {
		Lc39 test = new Lc39();
		int[] arr = new int[] { 2, 3, 6, 7 };
		System.out.println(test.combinationSum(arr, 7));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(result, candidates, new ArrayList<>(), 0, target);
		return result;
	}

	public void dfs(List<List<Integer>> result, int[] candidates, List<Integer> tempResult, int begin, int target) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			result.add(new ArrayList<>(tempResult));
			return;
		}
		if (candidates.length >= begin + 1) {
			dfs(result, candidates, tempResult, begin + 1, target);
		} else {
			return;
		}
		int remain = target - candidates[begin];
		tempResult.add(candidates[begin]);
		dfs(result, candidates, tempResult, begin, remain);
		tempResult.remove(tempResult.size() - 1);
	}

}
