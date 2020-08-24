package io.github.chinalhr.algorithm4.graph.mst;

import edu.princeton.cs.algs4.Bag;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>基于邻接表数据结构的加权有向图实现</h3>
 */
@SuppressWarnings("unchecked")
public class EdgeWeightedGraph {


	private final int V; // 顶点总数
	private int E; // 边的总数
	private Bag<Edge>[] adj; // 邻接表

	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		//初始化Bag[]
		adj =  (Bag<Edge>[])new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Edge>();
	}

	/**
	 * 图的顶点数
	 * @return
	 */
	public int V() {
		return V;
	}

	/**
	 * 图的边数
	 * @return
	 */
	public int E() {
		return E;
	}

	/**
	 * 向图中添加一条边e
	 * @param e
	 */
	public void addEdge(Edge e) {
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	/**
	 * 和v关联的所有边
	 * @param v
	 * @return
	 */
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	/**
	 * 返回图所有的边
	 * @return
	 */
	public Iterable<Edge> edges() {
	        Bag<Edge> list = new Bag<Edge>();
	        for (int v = 0; v < V; v++) {
	            int selfLoops = 0;
	            for (Edge e : adj(v)) {
	                if (e.other(v) > v) {
	                    list.add(e);
	                }
	                else if (e.other(v) == v) {
	                    if (selfLoops % 2 == 0) list.add(e);
	                    selfLoops++;
	                }
	            }
	        }
	        return list;
	    }
}
