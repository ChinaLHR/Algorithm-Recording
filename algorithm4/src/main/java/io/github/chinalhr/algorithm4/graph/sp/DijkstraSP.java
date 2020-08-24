package io.github.chinalhr.algorithm4.graph.sp;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>基于Dijkstra算法的单源点最短路径实现</h3>
 * <pre>
 * 基本思想：
 * 维护两个数据结构，一个为已求出最短路径的顶点集合（用S表示），一个为其余未确定最短路径的顶点集合（用U表示），按最短路径长度的递增次序依次把第二组的顶点加入S中。
 * 在加入的过程中，总保持从源点v到S中各顶点的最短路径长度不大于从源点v到U中任何顶点的最短路径长度。此外，每个顶点对应一个距离，S中的顶点的距离就是从v到此顶点的最短路
 * 径长度，U中的顶点的距离，是从v到此顶点只包括S中的顶点为中间顶点的当前最短路径长度。
 *
 * 实现：
 * 不断地将distTo[]中最小的非树顶点放松并加入树，重复直到所有的顶点都在树中。
 * ①初始化，MinPQ只包含源点，距离为0，其他顶点距离为MAX。
 * ②不断重复将MinPQ权重最小的顶点取出并进行顶点放松
 *
 * 注意：要求不存在负权限
 * </pre>
 */
public class DijkstraSP {

	private DirectedEdge[] edgeTo;// 储存最短路径树中的边DirectedEdge
	private double[] distTo;// x顶点到达起点的已知最短路径距离
	private IndexMinPQ<Double> pq;// 保存需要被放松的顶点

	public DijkstraSP(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<>(G.V());

		//初始化distTo
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		pq.insert(s, 0.0);
		while (!pq.isEmpty())
			relax(G, pq.delMin());

	}

	/**
	 * 放松顶点
	 * 实现：
	 * 循环对指定顶点的邻边，将权重最低的边e加入edge[w],并将邻顶点加入MinPQ
	 * @param G
	 * @param v
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			//权重的判断：叠加
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (pq.contains(w))
					pq.change(w, distTo[w]);
				else
					pq.insert(w, distTo[w]);
			}
		}
	}

	/**
	 * 从顶点s到v的距离
	 * @param v
	 * @return
	 */
	public double distTo(int v) {
		return distTo[v];
	}

	/**
	 * 是否存在从订点到的路径
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	//返回从顶点到v的路径
		public Iterable<DirectedEdge> pathTo(int v) {
			if (!hasPathTo(v))
				return null;
			Stack<DirectedEdge> path = new Stack<DirectedEdge>();
			for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
				path.push(e);
			return path;
		}
}
