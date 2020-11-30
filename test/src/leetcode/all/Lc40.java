package leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/28 20:07
 */
public class Lc40 {
	public static void main(String[] args) {
		Lc40 test = new Lc40();
		int[] arr = new int[] { 2, 3, 6, 7 };
		System.out.println(test.combinationSum2(arr, 7));
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
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
		if (candidates.length < begin + 1) {
			return;
		}
		int temp = begin;
		//跳过逻辑,避免重复姐 重复的只会使用1 2 3 4 5 6 7 8   而不会1 2 2  3 3
		do {
			if (candidates[begin] != candidates[temp]) {
				break;
			}
			temp++;
		} while (temp < candidates.length);
		dfs(result, candidates, tempResult, temp, target);
		int remain = target - candidates[begin];
		tempResult.add(candidates[begin]);
		dfs(result, candidates, tempResult, begin + 1, remain);
		tempResult.remove(tempResult.size() - 1);
	}

}
