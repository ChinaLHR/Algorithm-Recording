package io.github.chinalhr.algorithm4.graph.directed;

import edu.princeton.cs.algs4.Bag;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>邻接表数据结构表示有向图</h3>
 */
@SuppressWarnings("unchecked")
public class Digraph {
	private final int V;// 顶点数目
	private int E; // 边的数目
	private Bag<Integer>[] adj;// 邻接表

	public Digraph(int V) {
		// 初始化邻接表
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	/**
	 * 向图中连接一条边：v——>w 与Graph不同的是只调用了一次adj[].add方法
	 *
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}

	/**
	 * 返回v的邻边
	 *
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	/**
	 * 返回该图的反向图
	 *
	 * @return
	 */
	public Digraph reverse() {
		Digraph R = new Digraph(V);
		for (int v = 0; v < V; v++)
			for (int w : adj(v))
				R.addEdge(w, v);
		return R;
	}
}
