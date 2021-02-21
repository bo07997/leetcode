package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/17 20:17
 */
public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
		System.out.println(val);
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
