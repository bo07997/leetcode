package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/12/15 18:02
 * 58. 最后一个单词的长度
 */
public class Lc58 {
	public int lengthOfLastWord(String s) {
		int end = s.length() - 1;
		for (; end >= 0; end--) {
			if (s.charAt(end) == ' ') {
				continue;
			}
			break;
		}
		int first = end;
		for (; first >= 0; first--) {
			if (s.charAt(first) != ' ') {
				continue;
			}
			break;
		}
		return end - first;
	}
}
