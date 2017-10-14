package com.lhr.algorithm4.graph;

import edu.princeton.cs.algs4.Stack;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>邻接表数据结构表示有向图，有向环的检测</h3>
 */
@SuppressWarnings("unused")
public class DirectedCycle {

	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;// 有向环中的所有顶点
	private boolean[] onStack;// 递归调用的栈上的所有顶点

	public DirectedCycle(Digraph G) {
		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			if (!marked[v])
				dfs(G, v);
	}
	
	/**
	 * DFS进行有向环的检测
	 * 实现：利用一个Stack存储有向环，onStack辅助标记
	 * ①用onStack标记起点
	 * ②进行dfs，如果回到起点，则证明存在有向环，使用Stack进行存储
	 * @param G
	 * @param v
	 */
	private void dfs(Digraph G, int v) {
		onStack[v] = true;
		marked[v] = true;
		for (int w : G.adj(v))
			if (this.hasCycle())//如果已经是有向环直接return
				return;
			else if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			} else if (onStack[w]) {
				cycle = new Stack<>();
				for (int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
		onStack[v] = false;
		
	}
	
	/**
	 * G是否含有有向环
	 * 
	 * @return
	 */
	public boolean hasCycle() {
		return cycle != null;
	}

	/**
	 * 有向环中的所有顶点
	 * 
	 * @return
	 */
	public Iterable<Integer> cycle() {
		return cycle;
	}
}
