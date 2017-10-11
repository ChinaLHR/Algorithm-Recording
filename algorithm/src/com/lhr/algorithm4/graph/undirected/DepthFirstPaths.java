package com.lhr.algorithm4.graph.undirected;

import com.lhr.algorithm4.graph.Graph;

import edu.princeton.cs.algs4.Stack;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>基于深度优先算法的路径寻找</h3>
 * <pre>
 * 实现思路:
 * 利用edgeTo[] :键->目标顶点  值 ->与目标顶点相邻的顶点(是一颗用父链接表示的s为根含有所有与s联通顶点的树)
 * 利用dfs记录每个与s连通的顶点回到s的路径.
 * 
 * pathTo : 
 * </pre>
 */
public class DepthFirstPaths {
	private boolean[] marked;//标记数组
	private int[] edgeTo;//从起点到一个顶点的已知路径上的最后一个顶点
	private final int s;//起点
	
	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
	}
	
	/**
	 * 是否存在从s到v的路径
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	/**
	 * 返回s到v的路径,如果不存在则返回null
	 * @param v
	 * @return
	 */
	public Iterable<Integer> pathTo(int v){
		if (!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<>();
		for (int x = v; x !=s; x = edgeTo[x]) 
			path.push(x);
		path.push(s);
		return path;
	}
}
