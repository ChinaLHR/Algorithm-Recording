package com.lhr.algorithm4.graph.undirected;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * 
 * <h3>邻接表数据结构表示无向图</h3>
 * <pre>
 * 性能：
 * ①使用的空间和V+E成正比
 * ②添加一条边复杂度为O(n)
 * ③处理每个相邻顶点所需时间为常数
 * </pre>
 */
@SuppressWarnings("unchecked")
public class Graph {
	
	private final int V;//顶点数量
	private int E;//边的数量
	private Bag<Integer>[] adj;// 邻接表
	
	
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];// 创建邻接表
		for (int v = 0; v < V; v++)// 将所有链表初始化为空
			adj[v] = new Bag<>();
	}
	
	public Graph(In in) {
		this(in.readInt()); // 读取V并将图初始化
		int E = in.readInt(); // 读取E
		for (int i = 0; i < E; i++) { // 读取一个顶点
			int v = in.readInt(); // 读取另一个顶点
			int w = in.readInt(); // 读取一个顶点
			addEdge(v, w); 
		}
	}
	
	/**
	 * 顶点数
	 * 
	 * @return
	 */
	public int V() {
		return V;
	}
	
	/**
	 * 边数
	 * 
	 * @return
	 */
	public int E() {
		return E;
	}
	
	/**
	 * 向图中连接一条边 v -> w
	 * 
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w); // 将W添加到v的链表中
		adj[w].add(v); // 将v添加到w的链表中
		E++;
	}
	
	/**
	 * 获取和v相邻的所有顶点
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	/**
	 * 计算v的度数（度数：依附于v的边的总数）
	 * @param v
	 * @return
	 */
	public int degree(int v) {
		int degree = 0;
		for (int w : adj(v))
			degree++;
		return degree;
	}
	
	/**
	 * 计算所有顶点的最大度数
	 * @return
	 */
	public int maxDegree() {
		int max = 0;
		for (int v = 0; v < V(); v++) 
			if (degree(v)>max) 
				max = degree(v);
		return max;
	}
	
	/**
	 * 计算自环的个数
	 * @return
	 */
	public int numberOfSelfLoops() {
		int count = 0;
		for (int v = 0; v < V(); v++) 
			for (int w : adj(v)) 
				if (v==w) 
					count++;
		//因为每条边都被记过两次
		return count/2;
	}
}
