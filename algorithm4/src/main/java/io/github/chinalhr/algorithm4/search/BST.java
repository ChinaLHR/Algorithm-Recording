package io.github.chinalhr.algorithm4.search;

import java.util.Queue;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>二叉查找树实现的有序符号表</h3>
 */
@SuppressWarnings("unused")
public class BST<Key extends Comparable<Key>,Value>{

	private Node root;//二叉查找树的根节点

	private class Node{
		private Key key;//键
		private Value val;//值
		private Node left,right;
		private int N;//以该节点为根的子树的节点总数

		public Node(Key key, Value val, int n) {
			super();
			this.key = key;
			this.val = val;
			N = n;
		}

	}

	/**
	 * 表中键值对的数量
	 * @return
	 */
	public int size() {
		return size(root);
	}

	/**
	 * 指定对象键值对的数量
	 * @param x
	 * @return
	 */
	public int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}

	/**
	 * 查找
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		return get(root,key);
	}

	/**
	 * 在以x为根节点的子树中查找并返回key所对应的值,如果找不到则返回null
	 * @param x
	 * @param key
	 * @return
	 */
	public Value get(Node x, Key key) {
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
	 * 插入一个结点
	 *
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val) {

		root = put(root, key, val);
	}

	/**
	 * 查找key，找到则更新它的值，否则创建一个新结点
	 * ①如果key存在于以x为根的结点则更新它的属性
	 * ②如果不存在,将以key，val为键值对插入到该子树中合适的位置并更新子节点为1
	 * @param x
	 * @param key
	 * @param val
	 * @return
	 */
	private Node put(Node x, Key key, Value val) {
		if (x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	/**
	 * 最小键
	 * 左树中的最小键
	 * @return
	 */
	public Key min() {
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null)
			return x;
		return min(x.left);
	}

	/**
	 * 最大键
	 * 右键中的最小键
	 * @return
	 */
	public Key max() {
		return max(root).key;
	}

	private Node max(Node x) {
		if (x.right == null)
			return x;
		return max(x.right);
	}

	/**
	 * 获得小于等于key的最大键
	 *
	 * @param key
	 * @return
	 */
	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null)
			return null;
		return x.key;
	}

	private Node floor(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0)
			return x;
		if (cmp < 0)
			return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t != null)
			return t;
		else
			return x;
	}

	/**
	 * 获得大于等于Key的最小键
	 *
	 * @param key
	 * @return
	 */
	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null)
			return null;
		return x.key;
	}

	private Node ceiling(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0)
			return x;
		if (cmp > 0)
			return ceiling(x.right, key);
		Node t = floor(x.left, key);
		if (t != null)
			return t;
		else
			return x;
	}

	/**
	 * 返回排名为k的键
	 *
	 * @param k
	 * @return
	 */
	public Key select(int k) {
		return select(root, k).key;
	}

	private Node select(Node x, int k) {

		if (x == null)
			return null;
		int t = size(x.left);//获取左键的数量

		//左键数量大于k，在左键中获取
		if (t > k)
			return select(x.left, k);
		//在右键中获取
		else if (t < k)
			return select(x.right, k - t - 1);
		else
			return x;
	}

	/**
	 * 返回键为key的排名（返回小于该键的数量）
	 * 实现：
	 * ①如果小于根，则继续查找，大于则添加左键数量+1再继续查找，等于则返回左键数量
	 * @param key
	 * @return
	 */
	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node x) {
		if (x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return rank(key, x.left);
		else if (cmp > 0)
			return 1 + size(x.left) + rank(key, x.right);
		else
			return size(x.left);
	}

	/**
	 * 删除最小键
	 * 实现：递归根节点的左树直到找到一个空链接,然后将指向该节点的右子节点指向该节点的父节点
	 */
	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	/**
	 * 删除某个键
	 *
	 * @param key
	 */
	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

}
