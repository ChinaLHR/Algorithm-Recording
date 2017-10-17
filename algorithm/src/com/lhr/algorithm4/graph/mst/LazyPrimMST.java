package com.lhr.algorithm4.graph.mst;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>Prim算法实现最小生成树的生成（延时实现）</h3>
 * <pre>
 * 
 * Prim思想：
 * 设图G顶点集合为U，首先任意选择图G中的一点作为起始点a，将该点加入集合V，再从集合U-V中找到另一点b使得点b到V中任意一点的权值最小，此时将b点
 * 也加入集合V；以此类推，直至所有顶点全部被加入V，此时就构建出了一颗MST。因为有N个顶点，所以该MST就有N-1条边，每一次向集合V中加入一个点，
 * 就意味着找到一条MST的边。
 * 
 * 延迟实现：将失效的边先留在优先队列中，等到要删除的时候再去检查边的有效性
 * 
 * 实现思路：
 * 使用Queue维护最小生成树的边，使用MinPQ实时维护最小生成树的邻边（已知最小生成树所有顶点的所有邻边）与最小权重，每次从MinPQ取出并删除权重最小边加入MST(需要做失效判断)
 * ,并将顶点相邻边加入MinPQ,依次往复
 * </pre>
 */
@SuppressWarnings("unused")
public class LazyPrimMST {
	
	private boolean[] marked;//最小生成树的顶点
	private Queue<Edge> mst;//最小生成树的边
	private MinPQ<Edge> pq;//优先队列：横切边，包括失效的边
	public LazyPrimMST(EdgeWeightedGraph G) {
		//初始化数据结构
		pq = new MinPQ<>();
		marked = new boolean[G.V()];
		mst = new Queue<>();
		//从顶点0开始生成
		visit(G, 0);
		while (!pq.isEmpty()) {
			Edge e = pq.delMin();//从pq中得到并删除权重最小的边
			int v = e.either(),w = e.other(v);
			//跳过失效的边
			if (marked[v]&&marked[w]) continue;
			//将边加入到最小生成树队列中
			mst.enqueue(e);
			//将顶点(v或者w)添加到树中
			if (!marked[v])
				visit(G, v);
			if (!marked[w])
				visit(G, w);
		}
	}
	
	/**
	 * 标记顶点v，并将所有连接V和未被标记顶点的边加入pq
	 * @param G
	 * @param v
	 */
	private void visit(EdgeWeightedGraph G,int v) {
		marked[v] = true;
		for (Edge e :G.adj(v))
			if (!marked[e.other(v)])
				pq.insert(e);
	}
	
	public Iterable<Edge> edges() {
		return mst;
	}
}
