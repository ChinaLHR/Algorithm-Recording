package io.github.chinalhr.algorithm4.base;

import java.util.Iterator;

/**
 * 队列-栈实现
 * @author 14204
 *
 */
public class StackArrayImpl <T> implements Iterable<T> {
	private T[] a = (T[]) new Object[1];
	private int N = 0;
	/**
	 * 将Stack移动到一个大小为max的新数组
	 * @param max
	 */
	private void resize(int max){
		T[] temp = (T[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}
	/**
	 * 添加元素到栈顶
	 * @param item
	 */
	public void push(T item) {
		//防止栈溢出，如果数组容纳大小满了，数组大小增倍
		if (N==a.length) resize(2*a.length);
		a[N++] = item;
	}
	/**
	 * 从栈顶删除元素
	 * @return
	 */
	public T pop() {
		T item = a[--N];
		a[N] = null;//避免对象游离
		//如果数组太大(等于item的4倍)，数组大小减半
		if (N>0&&N==a.length/4) resize(a.length/2);
		return item;
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}

	@Override
	public Iterator<T> iterator() {
		return new mArrayStack();
	}
	/**
	 * 支持后进先出的迭代
	 * @author 李涵嵘
	 *
	 */
	private class mArrayStack implements Iterator<T>{
		private int i = N;

		@Override
		public boolean hasNext() {
			return i>0;
		}
		@Override
		public T next() {
			return a[--i];
		}
	}
}
