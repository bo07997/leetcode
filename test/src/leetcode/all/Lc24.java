package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/17 20:26
 */
public class Lc24 {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode temp = head.next;
		head.next = swapPairs(temp.next);
		temp.next = head;
		return temp;
	}
}
