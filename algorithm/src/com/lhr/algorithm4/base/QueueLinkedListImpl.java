package com.lhr.algorithm4.base;

/**
 * 队列 链表实现
 * @author 14204
 *
 */
public class QueueLinkedListImpl<T> {

	private Node first;
	private Node last;
	private int N;

	public QueueLinkedListImpl() {
		first = null;
		last = null;
		N = 0;
	}
	/**
	 *  帮助链表类
	 * @param <T>
	 */
	class Node<T> {
		T data;
		Node next;
		public Node() {
			// 无参构造
		}

		public Node(T t) {
			this.data = t;
		}
	}

	/**
	 * 从队列的尾部插入结点
	 * 
	 * @param t
	 */
	public void add(T t) {
		Node oldlast = last;
		last = new Node();
		last.data = t;
		last.next = null;
		if (isEmpty())
			first = last;
		else
			oldlast.next = last;

		N++;
	}

	/**
	 * 从队列的头部删除
	 * 
	 * @return
	 */
	public T remove() {
		if (isEmpty()) 
			new NullPointerException("队列是空的!");
		
			if (null == first.next)
				last = null;
			T temp = (T) first.data;
			first = first.next;
			N--;
			if (isEmpty()) last = null;
		return temp;
	}
	/**
	 * 队列的长度
	 * @return
	 */
	public int N() {
		return N;
	}

	/**
	 * 返回队列头部的元素
	 * 
	 * @return
	 */
	public T peek() {
		if (isEmpty()) 
			new NullPointerException("队列是空的!");
			return (T) first.data;
	}

	public boolean isEmpty() {
		return first == null;
	}
}
