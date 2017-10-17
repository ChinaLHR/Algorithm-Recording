package com.lhr.algorithm4.graph.sp;

import edu.princeton.cs.algs4.Queue;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>基于BellmanFord算法的最短路径实现</h3>
 * 
 * 注意：可以解决边的负权重问题 但不能存在负权重环
 */
@SuppressWarnings("unused")
public class BellmanFordSP {
	
	private double[] distTo;//从起点到某个顶点的路径长度
	private DirectedEdge[] edgeTo;//从起点到某个顶点的最后一条边
	private boolean[] onQ;//该顶点是否存在于队列中
	private Queue<Integer> queue;//正在被放松的顶点
	private int cost;//relax()调用次数
	private Iterable<DirectedEdge> cycle;//edgeTo[]中是否存在负权重环
	
	public BellmanFordSP(EdgeWeightedDigraph G,int s) {
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		onQ = new boolean[G.V()];
		queue = new Queue<>();
		for (int v = 0; v < G.V(); v++) 
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		queue.enqueue(s);
		onQ[s] = true;
		while (!queue.isEmpty()&&!this.hasNegativeCycle()) {
			int v = queue.dequeue();
			onQ[v] = false;
			
		}
	}
	
	/**
	 * 将被成功放松的边指向的所有顶点加入一条FIFO队列中并周期性地检测edgeTo[]是否存在负权重环
	 * 
	 * @param G
	 * @param v
	 */
	private void relax(EdgeWeightedDigraph G,int v) {
		for(DirectedEdge e:G.adj(v))
		{
			int w = e.to();
			if (distTo[w]>distTo[v]+e.weight()) {
				distTo[w]=distTo[v]+e.weight();
				edgeTo[w] = e;
				if (!onQ[w]) {
					queue.enqueue(w);
					onQ[w] = true;
				}
			}
			//一个周期，检测环
			if (cost++ % G.V() == 0) 
				findNegativeCycle();
		}
	}
	
	
	/**
	 * 是否存在负权重环
	 * @return
	 */
	private boolean hasNegativeCycle() {
		return cycle!=null;
	}

	/**
	 * 负权重环的检测
	 */
	private void findNegativeCycle() {
		//TODO 待实现...
	}
}
