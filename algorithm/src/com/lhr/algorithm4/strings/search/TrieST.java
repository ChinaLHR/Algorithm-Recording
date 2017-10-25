package com.lhr.algorithm4.strings.search;

import com.sun.org.apache.regexp.internal.recompile;

import edu.princeton.cs.algs4.Queue;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>R向单词查找树数据结构</h3>
 * <pre>
 * 键：字符串 值：Value
 * 
 * 查找操作：
 * ①命中：键的尾字符对应的值非空
 * ②未命中：键的尾字符对应的值为空/结束于一条空链接
 * 
 * 插入操作：
 * 先进行一次查找操作：
 * ①在到达键的尾字符串之前就遇到了一个空链接：需要创建节点并将值保存在尾节点。
 * ②能够到达键的尾节点:替换尾节点的值
 * 
 * 删除操作：
 * ①找到对应的节点并设置值为null
 * ②如果该节点含有一个非空链接指向某个子节点，不需要其他操作
 * ③如果该节点的所有链接为空，那么删除它。
 * 
 * 缺陷：应避免在长字符串中使用该数据结构，单向分支过长而导致消耗空间
 * </pre>
 */
@SuppressWarnings("unchecked")
public class TrieST<Value> {

	private static int R = 256;//基数
	private Node root;//单词查找树的根节点
	
	/**
	 * 节点
	 */
	private static class Node{
		private Object val;//值
		private Node[] next = new Node[R];//子节点(索引为字符值)
	}
	
	/**
	 * 获取字符串key对应的值(递归)
	 * @param key
	 * @return
	 */
	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null) return null;
		return (Value) x.val;
	}
	
	private Node get(Node x,String key ,int d) {
		//返回以x作为根节点的子单词查找树中于key相关联的值
		if (x==null) return null;
		if (d == key.length()) return x;
		//找到d个字符,并搜索下一位
		char c = key.charAt(d);
		return get(x.next[c], key, d+1);
	}
	
	/**
	 * 插入字符串Key与值Value(递归)
	 * @param Key
	 * @param val
	 */
	public void put(String key,Value val) {
		root = put(root, key, val, 0);
	}
	
	private Node put(Node x,String key,Value val,int d) {
		if (x==null) x = new Node();
		//存在Key则更新Key的Value
		if (d == key.length()) {
			x.val = val;
			return x;
		}
		char c = key.charAt(d);//找到d个字符
		//递归插入对应字符的下一位
		x.next[c] = put(x.next[c], key, val, d+1);
		return x;
	}
	
	
	//------前缀匹配----------
	
	/**
	 * 获取所有的key(字符串)
	 * @return
	 */
	public Iterable<String> keys(){
		return keysWithPrefix("");
	}
	
	/**
	 * <h3>获取所有以x为前缀的字符串<h3>
	 * 实现：先获取到前缀的字符串节点,对节点的子节点进行递归筛选，选出前缀为pre的字符串
	 * @param pre
	 * @return
	 */
	public Iterable<String> keysWithPrefix(String pre){
		Queue<String> q = new Queue<>();
		collect(get(root,pre,0), pre, q);
		return q;
	}
	
	/**
	 * 递归访问前缀节点的子节点，如果遇到存在值的节点则将字符串保存到队列中
	 * @param x
	 * @param pre
	 * @param q
	 */
	private void collect(Node x,String pre,Queue<String> q) {
		if (x == null)return;
		if (x.val!=null) q.enqueue(pre);
		for (char c = 0; c < R; c++) {
			collect(x.next[c], pre+c, q);
		}
	}
	
	//-------通配符匹配--------
	/**
	 * 所有和pat匹配的键
	 * @param pat
	 * @return
	 */
	public Iterable<String> keysThatMatch(String pat){
		Queue<String> q = new Queue<String>();
		collect(root, "", pat, q);
		return q;
	}
	
	/**
	 * 实现：从根节点开始搜索含有pat的节点，存在则加入队列中
	 * @param x
	 * @param pre
	 * @param pat
	 * @param q
	 */
	private void collect(Node x,String pre,String pat,Queue<String> q) 
	{
		int d = pre.length();
		if (x == null) return;
		if (d==pat.length()&&x.val!=null) q.enqueue(pre);
		if (d==pat.length()) return;
		
		char next = pat.charAt(d);
		for (char c = 0; c<R; c++) 
			if (next == '.'||next == c) {
				collect(x.next[c],pre+c, pat, q);
			}
	}
	
	//-------最长前缀-------
	
	/**
	 * s的前缀中最长的键(shell——>she)
	 * @param s
	 * @return
	 */
	public String longstPrefixOf(String s) {
		int length = search(root, s, 0, 0);
		return s.substring(0,length);
	}
	
	/**
	 * 从根节点开始，循环获取字符串的各个字节用户获取最长键的长度，用length表示
	 * @param x
	 * @param s
	 * @param d
	 * @param length
	 * @return
	 */
	private int search(Node x,String s,int d,int length) {
		if (x == null) return length;
		if (x.val!=null) length = d;
		if (d == s.length()) return length;
		char c = s.charAt(d);
		return search(x.next[c], s, d+1, length);
	}
	
	//--------删除操作--------
	/**
	 * 删除键key
	 * @param key
	 */
	public void delete(String key) {
		root = delete(root,key,0);
	}
	
	private Node delete(Node x,String key,int d) {
		if (x==null) return null;
		if (d==key.length()) x.val = null;
		else 
		{
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d+1);
		}
		if (x.val!=null) return x;
		
		for (char c = 0;c<R;c++) 
			if (x.next[c]!=null) return x;
		return null;
	}
	
	
}
