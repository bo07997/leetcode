package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/14 19:38
 */
public class Lc19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head.next == null) {
			return null;
		}
		ListNode first = null;
		ListNode end = head;
		for (int i = 1; i < n; i++) {
			end = end.next;
		}
		while (end.next != null) {
			if (first == null) {
				first = head;
			} else {
				first = first.next;
			}
			end = end.next;
		}
		if (first != null) {
			first.next = first.next.next;
		} else {
			return head.next;
		}
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
