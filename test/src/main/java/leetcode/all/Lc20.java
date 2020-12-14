package leetcode.all;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/14 20:25
 */
public class Lc20 {
	public static void main(String[] args) {
		boolean test = isValid("()[]");
	}

	public static boolean isValid(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
		Map<Character, Character> relationMap = new HashMap<>();
		relationMap.put('[', ']');
		relationMap.put('{', '}');
		relationMap.put('(', ')');
		Deque<Character> stack = new LinkedList<>();
		for (int i = s.length() - 1; i >= 0; i--) {
			Character c = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(c);
				continue;
			}
			if (stack.peek().equals(relationMap.get(c))) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
}
