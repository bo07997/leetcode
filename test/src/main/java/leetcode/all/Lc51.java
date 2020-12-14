package leetcode.all;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/12/12 15:40
 * 51. N 皇后  解法改自47
 */
public class Lc51 {

	public static void main(String[] args) {
		Lc51 lc51 = new Lc51();
		System.out.println(lc51.solveNQueens(5));
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		if (n == 0) {
			return result;
		}
		boolean[] used = new boolean[n];
		boolean[] used1 = new boolean[2 * n - 1];
		boolean[] used2 = new boolean[2 * n - 1];
		Deque<String> path = new ArrayDeque<>(n);
		char[] base = new char[n];
		for (int i = 0; i < n; i++) {
			base[i] = '.';
		}
		dfs(base, result, n, 0, path, used, used1, used2);
		return result;
	}

	public void dfs(char[] base, List<List<String>> result, int n, int depth, Deque<String> path,
			boolean[] used, boolean[] used1, boolean[] used2) {
		if (n == depth) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (used[i] || used1[(depth + i) % used2.length] || used2[(depth + n - i) % used2.length]) {
				continue;
			}
			used[i] = true;
			used1[(depth + i) % used2.length] = true;
			used2[(depth + n - i) % used2.length] = true;
			base[i] = 'Q';
			path.addLast(String.valueOf(base));
			base[i] = '.';
			dfs(base, result, n, depth + 1, path, used, used1, used2);
			used[i] = false;
			used1[(depth + i) % used2.length] = false;
			used2[(depth + n - i) % used2.length] = false;
			path.removeLast();
		}
	}

}
