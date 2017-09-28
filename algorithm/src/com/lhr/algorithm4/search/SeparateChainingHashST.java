package com.lhr.algorithm4.search;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>基于拉链法实现的散列表<h3>
 * <pre>
 * 散列表：
 * 是在空间与时间上做出权衡的算法
 * 
 * 实现步骤：
 * 一：用散列函数将被查找的键转化为数组的一个索引。（散列函数）
 * 二：处理碰撞冲突（解决多个键散列到相同的索引值），拉链法与线性探测法。
 * 
 * 拉链法：
 * 将数组中的每个元素指向一条链表，链表中的每个结点都存储了散列值为该元素的索引的键值对。这种方法被称为拉链法，
 * 基本思想：
 * 选择足够大的M，使得所有链表都尽可能短以保证高效的查找。查找分两步：首先根据散列值找到对应的链表．然后沿着链表顺序查找相应的键。
 * </pre>
 */
@SuppressWarnings("unchecked")
public class SeparateChainingHashST<Key,Value> {
	private int N;//键值对的总数
	private int M;//散列表的大小
	
	private SequentialSearchST<Key, Value>[] st;//存放链表数据的数组

	public SeparateChainingHashST() {
		this(997);
	}	
	
	/**
	 * 初始化拉链表
	 * @param m ： 数组大小
	 */
	public SeparateChainingHashST(int m) {
		M = m;
		st =(SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for (int i = 0; i < M; i++)
			st[i] = new SequentialSearchST();
	}
	
	/**
	 * 将Key的hashCode转换为数组的索引
	 * @param key
	 * @return
	 */
	private int hash(Key key){
		return (key.hashCode()&0x7fffffff)%M;
	}
	
	/**
	 * 根据key获取value
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		return (Value)st[hash(key)].get(key);
	}
	
	/**
	 * 存入键值对
	 * @param key
	 * @param value
	 */
	public void put(Key key,Value val){
		st[hash(key)].put(key, val);
	}
}
