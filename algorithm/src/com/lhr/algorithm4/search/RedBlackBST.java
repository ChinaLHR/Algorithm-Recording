package com.lhr.algorithm4.search;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>红黑二叉查找树</h3>
 * 
 *          <pre>
 * 基本思想：使用标准的二叉查找树和一些额外信息来表示2-3树，将3-节点表示为一条左斜的红色链接,将红黑树铺平之后，会形成一颗2-3树
 * 实现
 * ①旋转：修复链接的错误（红色有链接与两条连续的红色链接），旋转后重置父节点的链接，保证红黑树的有序性与平衡性
 * 
 *          </pre>
 */
@SuppressWarnings("unused")
public class RedBlackBST<Key extends Comparable<Key>, Value> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private Node root;

	private class Node {
		Key key;// 键
		Value val;// 值
		Node left, right;// 左右子树
		int N;// 子树中的节点总数
		boolean color;// 其父节点指向它的链接的颜色

		public Node(Key key, Value val, int n, boolean color) {
			this.key = key;
			this.val = val;
			N = n;
			this.color = color;
		}
	}

	public Value get(Key key) {
		return get(root, key);
	}

	/**
	 * 使用二分查找对红黑树进行查询
	 * 
	 * @param x
	 * @param key
	 * @return
	 */
	private Value get(Node x, Key key) {
		// 在以x为根节点的子树中查找并返回key所对应的值
		// 如果找不到则返回null
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.val;
	}

	/**
	 * 插入操作
	 * 
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val) {
		// 找到key，找到则更新值，否则为它新建一个结点
		root = put(root, key, val);
		root.color = BLACK;
	}

	/**
	 * <pre>
	 * 插入状态分为：
	 * ①向根2-结点中插入新键
	 * ②向树底部的2-结点插入新键
	 * ③向3-结点插入新键（旋转次数）
	 * </pre>
	 * @param h
	 * @param key
	 * @param val
	 * @return
	 */
	private Node put(Node h, Key key, Value val) {
		if (h == null) // 标准的插入操作，和父结点用红链接相连
			return new Node(key, val, 1, RED);
		int cmp = key.compareTo(h.key);
		if (cmp < 0)
			h.left = put(h.left, key, val);
		else if (cmp > 0)
			h.right = put(h.right, key, val);
		else
			h.val = val;
		//如果右子结点是红色的而左子结点是黑色的，进行左旋转；
	    //如果左子结点是红色的且左结点它的左子结点也是红色的，进行右旋转；
		//如果左右子结点均为红色，进行颜色转换。
		if (isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}

	/**
	 * 局部颜色转换
	 * @param h
	 */
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	private boolean isRed(Node x) {
		// 空链接为黑色
		if (x == null)
			return false;
		return x.color == RED;
	}

	/**
	 * 右旋转
	 * 
	 * @return
	 */
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}

	/**
	 * 左旋转
	 * 
	 * @param h
	 * @return
	 */
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}

	/**
	 * 符号表中键值对的数量
	 * 
	 * @return
	 */
	public int size() {
		return size(root);
	}

	/**
	 * 指定对象键值对的数量
	 * 
	 * @return
	 */
	public int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}
}
