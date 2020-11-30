package leetcode.all;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ldb
 * @Package leetcode.all
 * @date 2020/11/17 16:13
 */
public class Lc23 {
	public static void main(String[] args) {
		Lc23 t = new Lc23();
		ListNode[] lists = new ListNode[1];
		lists[0] = new ListNode(4);
		t.mergeKLists(new ListNode[] { parse(1) });
	}

	static ListNode parse(int... val) {
		List<ListNode> lists = Arrays.stream(val).mapToObj(ListNode::new).collect(Collectors.toList());
		for (int i = 0; i < lists.size() - 1; i++) {
			lists.get(i).next = lists.get(i + 1);
		}
		return lists.get(0);
	}

	static class ListNode {
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

	public ListNode mergeKLists(ListNode[] lists) {
		return mergeKLists(lists, 0, lists.length);
	}

	public ListNode mergeKLists(ListNode[] lists, int begin, int end) {
		if (lists.length == 0) {
			return null;
		}
		if (begin == end) {
			return lists[begin];
		}
		int mid = (begin + end) >> 1;
		return mergeTwoLists(mergeKLists(lists, begin, mid), mergeKLists(lists, mid + 1, end));
	}

	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		if (a.val < b.val) {
			a.next = mergeTwoLists(a.next, b);
			return a;
		} else {
			b.next = mergeTwoLists(b.next, a);
			return b;
		}

	}

	//	public ListNode mergeKLists(ListNode result, ListNode[] lists) {
	//		int count = 0;
	//		int index = 0;
	//		for (int i = 0; i < lists.length; i++) {
	//			if (lists[i] == null) {
	//				continue;
	//			}
	//			count++;
	//			if (lists[index] == null || lists[index].val > lists[i].val) {
	//				index = i;
	//			}
	//		}
	//		if (lists.length == 0 || lists[index] == null) {
	//			return result;
	//		}
	//		ListNode next = lists[index];
	//		if (result == null) {
	//			result = next;
	//		} else {
	//			result.next = next;
	//		}
	//		lists[index] = lists[index].next;
	//		if (lists[index] == null && count - 1 <= 0) {
	//			return result;
	//		}
	//		mergeKLists(next, lists);
	//		return result;
	//	}

}
