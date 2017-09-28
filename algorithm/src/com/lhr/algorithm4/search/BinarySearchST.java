package com.lhr.algorithm4.search;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>二分查找与数组实现的有序符号表</h3>
 * <pre>
 * 数据结构实现：使用一对平行数组，一个存储键，一个存储值
 * 使用了二分查找
 * 缺陷：虽然使用二分查找减少了比较次数但是put操作还是很慢，因为构建一个基于有序数组的符号表的时间复杂度是数组长度的平方级别
 * </pre>
 */
@SuppressWarnings("unchecked")
public class BinarySearchST<Key extends Comparable<Key>, Value> {

	private Key[] keys;
	private Value[] vals;
	private int N;

	public BinarySearchST(int capacity) {
		super();
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	
	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Value get(Key key) {
		if (isEmpty())
			return null;
		//得到给定键的索引
		int i = rank(key);
		System.out.println("get:"+i);
		if (i < N && keys[i].compareTo(key) == 0)
			return vals[i];
		else
			return null;
	}

	public void put(Key key, Value val) {
		//得到给定键的索引
		int i = rank(key);
		System.out.println("put:"+i);
		//如果给定键存在,则更新值
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}
		//如果键不存在,则创建一个新的
		//将所有更大的键向后移动一格腾出位置给i插入，保持数组是有序的
		for (int j = N; j > i; j--) {
			keys[j] = keys[j-1]; 
			vals[j] = vals[j-1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}

	public int rank(Key key) {
		int lo = 0;
		int hi = N - 1;
		return rank(key, lo, hi);
	}

	/**
	 * <pre>
	 * 二分查找实现(递归实现)
	 *  如果表中存在该键，rank()返回该键的位置，也就是小于它的键的数量
	 *  如果表中不存在该键，rank()返回表中小于该键的数量
	 *  </pre>
	 * @param key
	 * @param lo
	 * @param hi
	 * @return
	 */
	public int rank(Key key, int lo, int hi) {
		if (hi < lo)
			return lo;
		int mid = lo + (hi - lo) / 2;
		int cmp = key.compareTo(keys[mid]);
		if (cmp < 0)
			return rank(key, lo, mid - 1);
		else if (cmp > 0)
			return rank(key, mid + 1, hi);
		else
			return mid;
	}
	
	/**
	 * 二分查找实现(循环实现)
	 *  
	 * @param key
	 * @param lo
	 * @param hi
	 * @return
	 */
	public int rank2(Key key) {
		int lo = 0, hi = N-1;
		while (lo<=hi) {
			int mid = lo + (hi-lo)/2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp<0) hi = mid-1;
			else if(cmp>0)lo = mid+1;
			else return mid;
		}
		return lo;
	}
	
	
	
	public Key min() {
		return keys[0];
	}
	
	public Key max() {
		return keys[N];
	}
	
	public Key select(int k) {
		return keys[k];
	}
	
	/**
	 * 大于等于key的最小键
	 * @param key
	 * @return
	 */
	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}
	
	
	
}
