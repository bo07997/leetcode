package leetcode.all;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/17 20:34
 */
public class Lc25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1) {
			return head;
		}
		ListNode temp1 = head;
		for (int i = 0; i < k - 1; i++) {
			if (temp1 == null) {
				return head;
			}
			temp1 = temp1.next;
			if (temp1 == null) {
				return head;
			}
		}
		ListNode next = temp1.next;
		temp1.next = null;
		reverseK(head);
		head.next = reverseKGroup(next, k);
		return temp1;
	}

	public ListNode reverseK(ListNode head) {
		//递归终止条件是当前为空，或者下一个节点为空
		if (head == null || head.next == null) {
			return head;
		}
		//这里的cur就是最后一个节点
		ListNode cur = reverseK(head.next);
		//这里请配合动画演示理解
		//如果链表是 1->2->3->4->5，那么此时的cur就是5
		//而head是4，head的下一个是5，下下一个是空
		//所以head.next.next 就是5->4
		head.next.next = head;
		//防止链表循环，需要将head.next设置为空
		head.next = null;
		//每层递归函数都返回cur，也就是最后一个节点
		return cur;
	}

}
