package leetcode.all;

import java.util.*;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/12/12 15:40
 * 60. 排列序列  解法改自47
 */
public class Lc60 {

	public static void main(String[] args) {
		Queue<Integer> test = new LinkedList<>(Arrays.asList(1, 2, 3));
		test.add(4);
		exit:
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			for (int j = 0; j < 3; j++) {
				if (i == 2 && j == 2) {
					break exit;
				}
			}

		}
	}

	public String getPermutation(int n, int k) {
		if (n == 0) {
			return "";
		}
		boolean[] used = new boolean[n];
		List<Integer> seedList = new ArrayList<>();
		StringBuilder path = new StringBuilder();
		seedList.add(1);
		for (int i = 2; i < 10; i++) {
			seedList.add(seedList.get(i - 2) * i);
		}
		return path.toString();
	}

	//=============DFS+剪支
	//	public String getPermutation(int n, int k) {
	//		if (n == 0) {
	//			return "";
	//		}
	//		boolean[] used = new boolean[n];
	//		StringBuilder builder = new StringBuilder();
	//		dfs(k, 0, builder, used);
	//		return builder.toString();
	//	}
	//
	//	public int dfs(int k, int depth, StringBuilder path,
	//			boolean[] used) {
	//		if (used.length == depth) {
	//			return k - 1;
	//		}
	//		int result = k;
	//		for (int i = 0; i < used.length; i++) {
	//			if (used[i]) {
	//				continue;
	//			}
	//			used[i] = true;
	//			path.append(i + 1);
	//			result = dfs(result, depth + 1, path, used);
	//			if (result == 0) {
	//				return 0;
	//			}
	//			used[i] = false;
	//			path.deleteCharAt(path.length() - 1);
	//		}
	//		return result;
	//	}

}
