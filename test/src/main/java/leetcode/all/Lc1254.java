package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/30 16:47
 */
public class Lc1254 {
	public static void main(String[] args) {
		String s = "1";
		Lc1254 lc121 = new Lc1254();
	}

	public int closedIsland(int[][] grid) {
		int res = 0;
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				if (grid[i][j] == 0 && dfs(grid, i, j)) {
					res++;
				}
			}
		}
		return res;
	}

	public boolean dfs(int[][] grid, int i, int j) {
		int iMax = grid.length;
		int jMax = grid[0].length;
		if (i < 0 || j < 0 || i >= iMax || j >= jMax) {
			return false;
		}
		if (grid[i][j] == 1) {
			return true;
		}
		grid[i][j] = 1;
		boolean up = dfs(grid, i - 1, j);
		boolean down = dfs(grid, i + 1, j);
		boolean left = dfs(grid, i, j - 1);
		boolean right = dfs(grid, i, j + 1);
		if (up && down && left && right) {
			return true;
		}
		return false;
	}
}
