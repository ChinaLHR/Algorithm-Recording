package com.lhr.algorithm4.graph.undirected;

import com.lhr.algorithm4.graph.Graph;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>深度优先搜索</h3>
 * <pre>
 * 实现思路：使用一个boolean数组来记录和起点连通的所有顶点。
 * ①访问一个顶点时，将它标记为已访问.
 * ②递归地访问它的所有没有标记过的邻居节点进行标记.
 * </pre>
 */
@SuppressWarnings("unused")
public class DepthFirstSearch {
	
	private boolean[] marked;
	
	private int count;

	public DepthFirstSearch(Graph G,int s) {
		marked = new boolean[G.V()];
	}
	
	private void dfs(Graph G,int v) {
		marked[v] = true;
		count++;
		for(int w:G.adj(v))
			if (!marked[w])
				dfs(G, w);
	}
	
	public boolean marked(int w) {
		return marked[w];
	}
	
	public int count() {
		return count;
	}
}
