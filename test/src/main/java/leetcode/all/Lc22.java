package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/16 19:44
 */
public class Lc22 {
	List[] cache = new ArrayList[100];

	public static void main(String[] args) {
		Lc22 test = new Lc22();
		//		List<String> t1 = test.generate(5);
		List<String> t2 = test.generateParenthesis(5);
	}

	//	public List<String> generateParenthesis(int n) {
	//		if (cache[n] != null) {
	//			return cache[n];
	//		}
	//		List<String> list = new ArrayList<>();
	//		if (n == 0) {//边界条件的判断
	//			list.add("");
	//			return list;
	//		}
	//		for (int m = 0; m < n; m++) {
	//			int k = n - m - 1;
	//			List<String> first = generateParenthesis(m);
	//			if (cache[m] == null) {
	//				cache[m] = first;
	//			}
	//			List<String> second = generateParenthesis(k);
	//			if (cache[k] == null) {
	//				cache[k] = second;
	//			}
	//			for (String left : first) {
	//				for (String right : second) {
	//					list.add("(" + left + ")" + right);
	//				}
	//			}
	//		}
	//		return list;
	//	}
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		// 特判
		if (n == 0) {
			return res;
		}

		dfs("", 0, 0, n, res);
		return res;
	}

	public void dfs(String curStr, int left, int right, int n, List<String> res) {
		if (left == n && right == n) {
			res.add(curStr);
			return;
		}
		if (left < right) {
			return;
		}
		if (left < n) {
			dfs(curStr + "(", left + 1, right, n, res);
		}
		if (right < n) {
			dfs(curStr + ")", left, right + 1, n, res);
		}
	}

	//	public List<String> generateParenthesis(int n) {
	//		return new ArrayList<>(generateParenthesisSet(n));
	//	}
	//
	//	private Set<String> generateParenthesisSet(int n) {
	//		if (n == 0) {
	//			return new HashSet<>();
	//		}
	//		if (n == 1) {
	//			return new HashSet<>(Arrays.asList("()"));
	//		}
	//		Set<String> result = generateParenthesisSet(n - 1);
	//		return result.stream().flatMap(str -> Stream.of("()" + str, "(" + str + ")", str + "()"))
	//				.collect(Collectors.toSet());
	//	}
}
