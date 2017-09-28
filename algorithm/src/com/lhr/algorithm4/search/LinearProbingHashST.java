package com.lhr.algorithm4.search;

/**
 * 
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>基于线性探测的散列表</h3>
 * <pre>
 * 基于开放地址散列表：用大小为M的数组保存N个键值对，其中M>N。依靠数组中的空位解决碰撞冲突。
 * 
 * 实现：
 * 维护两个数组，一个存储键，一个存储值，当碰撞发生时（当一个键的散列值已经被另一个不同的键占用），我们直接检查散列表中的下一个位置（将索引位加1）,使用null表示一簇键的结束。
 * 实际上是在检测键是否为null。
 * 
 * 思想：
 * 将内存用左散列表中的空元素，利用空元素作为查找结束的标志
 * </pre>
 */
@SuppressWarnings("unchecked")
public class LinearProbingHashST<Key,Value> {

	private static final int INIT_CAPACITY = 4;
	
	private int N; // 符号表中键值对的总数
	private int M;// 线性探测表的大小
	private Key[] keys;// 键
	private Value[] vals;// 值
	
	public LinearProbingHashST() {
		this(INIT_CAPACITY);
	}

	public LinearProbingHashST(int cap) {
		M = cap;
		N = 0;
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	
	/**
	 * 插入数据
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val) {
		if (N >= M / 2)
			resize(2 * M);// 自动调整数组大小

		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % M)
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		//是一个空值，直接存储在哪里
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	/**
	 * 根据键获取值(使用null表示一簇键的结束)
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
			if (keys[i].equals(key))
				return vals[i];
		return null;
	}
	
	/**
	 * 调整线性探测表
	 * 
	 * @param cap
	 */
	private void resize(int cap) {
		LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(cap);
		for (int i = 0; i < M; i++)
			if (keys[i] != null)
				t.put(keys[i], vals[i]);
	
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
	
	/**
	 * 删除操作
	 * 实现：不能直接置为null,会导致后续的元素无法查找到，需要将簇中被删除键的右侧所有键重新插入散列表
	 * @param key
	 */
	public void delete(Key key) {
		if (!contains(key))
			return;
		int i = hash(key);
		while (!key.equals(keys[i]))
			i = (i + 1) % M;
		keys[i] = null;
		vals[i] = null;
		i = (i + 1) % M;
		while (keys[i] != null) {
			Key keyToRedo = keys[i];
			Value valToRedo = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyToRedo, valToRedo);
			i = (i + 1) % M;
		}
		N--;
		if (N > 0 && N == M / 8)
			resize(M / 2);
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public boolean contains(Key key) {
		if (key == null)
			throw new IllegalArgumentException("contains() is null");
		return get(key) != null;
	}
	
}
