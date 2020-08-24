package io.github.chinalhr.algorithm4.base;

public class StackLinkedListImpl<T> {
	private Node<T> first;//栈顶
	private int n; //元素数量

	private static class Node<T> {
		private T item;
		private Node<T> next;
	}

	public StackLinkedListImpl() {
		first = null;
		n = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	/**
	 * 添加item到Stack中
	 *
	 * @param item
	 */
	public void push(T item) {
		Node<T> oldfirst = first;
		first = new Node<T>();
		first.item = item;
		first.next = oldfirst;
		n++;
	}

	/**
	 * 返回并删除栈顶元素
	 *
	 * @return
	 */
	public T pop() {
		if (isEmpty())
			throw new NullPointerException("Stack underflow");
		T item = first.item;
		first = first.next;
		n--;
		return item;
	}

	/**
	 * 返回（但不删除）栈顶元素
	 * @return
	 */
	public T peek() {
		if (isEmpty())
			throw new NullPointerException("Stack underflow");
		return first.item;
	}

}
