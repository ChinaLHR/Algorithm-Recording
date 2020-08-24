package io.github.chinalhr.algorithm4.strings.search;
/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>三向单词查找树</h3>
 *
 *          <pre>
 * 结构：每个结点含有一个字符，三条链接(对应小于，等于和大于结点字母的所有键)和一个值
 * 查找：
 * 比较键的首字母和根节点的字母，如果键的首字母比较小就选择左链接，比较大就选择右链接，如果相等就选择中链接，如果遇到空链接或者节点的值为null，未命中
 *
 * 插入：
 * 先查找，找到更新值，找不到补全节点
 *
 * 删除：
 * 需要用二叉树中的删除操作删除
 *          </pre>
 */
public class TST<Value> {

	private Node root;// 树的根节点

	private static class Node {
		char c;// 字符
		Node left, mid, right;// 左中右子三向单词查询树
		Object val;// 和字符串相关联的值
	}

	/**
	 * 获取字符串key对应的值
	 *
	 * @param key
	 * @return
	 */
	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return (Value) x.val;
	}

	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		char c = key.charAt(d);
		if (c < x.c)
			return get(x.left, key, d);
		else if (c > x.c)
			return get(x.right, key, d);
		else if (d < key.length() - 1)
			return get(x.mid, key, d - 1);
		else
			return x;
	}

	/**
	 * 插入字符串与对应的值
	 * @param key
	 * @param val
	 */
	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		char c = key.charAt(d);
		if (x == null) { x = new Node();x.c = c;}//节点为null新建节点
		if (c<x.c) x.left = put(x.left, key, val, d);
		else if (c>x.c) x.right = put(x.right, key, val, d);
		else if (d<key.length() - 1)
			x.mid = put(x.mid, key, val, d+1);
		else x.val = val;
		return x;
	}
}
