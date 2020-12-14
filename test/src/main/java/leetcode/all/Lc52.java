package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/12/12 15:40
 * 51. N 皇后2  解法改自47
 */
public class Lc52 {

	public static void main(String[] args) {
		Lc52 lc51 = new Lc52();
		System.out.println(lc51.totalNQueens(4));
	}

	public int totalNQueens(int n) {
		if (n == 0) {
			return 0;
		}
		boolean[] used = new boolean[n];
		boolean[] used1 = new boolean[2 * n - 1];
		boolean[] used2 = new boolean[2 * n - 1];
		return dfs(n, 0, used, used1, used2);
	}

	public int dfs(int n, int depth,
			boolean[] used, boolean[] used1, boolean[] used2) {
		if (n == depth) {
			return 1;
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (used[i] || used1[(depth + i) % used2.length] || used2[(depth + n - i) % used2.length]) {
				continue;
			}
			used[i] = true;
			used1[(depth + i) % used2.length] = true;
			used2[(depth + n - i) % used2.length] = true;
			result += dfs(n, depth + 1, used, used1, used2);
			used[i] = false;
			used1[(depth + i) % used2.length] = false;
			used2[(depth + n - i) % used2.length] = false;
		}
		return result;
	}

}
