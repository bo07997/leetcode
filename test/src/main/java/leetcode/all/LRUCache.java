package leetcode.all;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	DLinkedNode head;
	DLinkedNode tail;
	int size;
	int capacity;
	private Map<Integer, DLinkedNode> cache;

	public LRUCache(int capacity) {
		this.head = new DLinkedNode();
		this.tail = new DLinkedNode();
		head.next = tail;
		tail.pre = head;
		this.capacity = capacity;
		this.cache = new HashMap<>();
	}

	static class DLinkedNode {
		int key;
		int value;
		DLinkedNode pre;
		DLinkedNode next;

		public DLinkedNode() {
		}

		public DLinkedNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			return -1;
		}
		//额外维护操作
		moveToHead(node);
		return node.value;
	}

	void delNode(DLinkedNode node) {
		cache.remove(node.key);
		size--;
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	void addToHead(DLinkedNode node) {
		node.pre = head;
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
		size++;
		cache.put(node.key, node);
	}

	void moveToHead(DLinkedNode node) {
		delNode(node);
		addToHead(node);
	}

	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			node = new DLinkedNode(key, value);
			addToHead(node);
			if (size > capacity) {
				delNode(tail.pre);
			}
		} else {
			node.value = value;
			moveToHead(node);
		}
	}
}
