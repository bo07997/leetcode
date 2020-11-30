package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/23 15:46
 */
public class Lc37 {
	int[][] row = new int[9][10];
	int[][] col = new int[9][10];
	int[][] box = new int[9][10];

	public static void main(String[] args) {
		char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		Lc37 test = new Lc37();
		test.solveSudoku(board);
		Lc36 valid = new Lc36();
		System.out.println(valid.isValidSudoku(board));
	}

	public void solveSudoku(char[][] board) {
		deal(board);
		solveSudoku(board, 0, 0);
	}

	public void deal(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				int curNum = board[i][j] - '0';
				row[i][curNum] = 1;
				col[j][curNum] = 1;
				box[j / 3 + (i / 3) * 3][curNum] = 1;
			}
		}
	}

	public boolean solveSudoku(char[][] board, int i, int j) {
		if (i >= 9 || j >= 9) {
			return true;
		}
		while (board[i][j] != '.') {
			if (j + 1 < 9) {
				j++;
			} else if (i + 1 < 9) {
				i++;
				j = 0;
			} else {
				return true;
			}
		}
		for (int curNum = 1; curNum <= 9; curNum++) {
			int nextI = i;
			int nextJ = j + 1;
			if (nextJ >= 9) {
				nextI++;
				nextJ = 0;
			}
			if (setSudoku(board, i, j, curNum)) {
				if (!solveSudoku(board, nextI, nextJ)) {
					unsetSudoku(board, i, j, curNum);
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public boolean setSudoku(char[][] board, int i, int j, int curNum) {
		if (row[i][curNum] == 1) {
			return false;
		}
		if (col[j][curNum] == 1) {
			return false;
		}
		if (box[j / 3 + (i / 3) * 3][curNum] == 1) {
			return false;
		}
		row[i][curNum] = 1;
		col[j][curNum] = 1;
		box[j / 3 + (i / 3) * 3][curNum] = 1;
		board[i][j] = Character.forDigit(curNum, 10);
		return true;
	}

	public void unsetSudoku(char[][] board, int i, int j, int curNum) {
		row[i][curNum] = 0;
		col[j][curNum] = 0;
		box[j / 3 + (i / 3) * 3][curNum] = 0;
		board[i][j] = '.';
	}

}
