package com.lhr.algorithm4.search;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>基于无序链表实现的符号表</h3>
 *          <pre>
 *          使用了顺序查找
 *          </pre>
 */
public class SequentialSearchST<Key, Value> {

	private int N;
	private Node first;

	public class Node {
		// 链表的节点定义
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next) {
			super();
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	public Value get(Key key) {
		// 查找给定的键，返回相关联的值
		for (Node x = first; x != null; x = x.next)
			if (key.equals(key))
				return x.val;
		// 找不到返回null
		return null;
	}

	public void put(Key key, Value value) {
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key)) {
				x.val = value;// 找到key，赋值给value
				return;
			}

		first = new Node(key, value, first);// 找不到key，创建新的节点
		N++;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	
	public void delete(Key key) {
		first = delete(first, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null)
			return null;
		if (key.equals(x.key)) {
			N--;
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}

}
