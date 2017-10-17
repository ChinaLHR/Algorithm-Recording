package com.lhr.algorithm4.graph.directed;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>基于Kosaraju算法实现的检测有向图顶点间强可达性</h3>
 * <pre>
 * 实现：
 * ①使用有向图的反图进行顶点排序，获取逆后序排序进行dfs
 * ②使用int[]记录强可达性顶点的分量
 * </pre>
 */
@SuppressWarnings("unused")
public class KosarajuSCC {
	
	private boolean[] marked;//已经访问过的顶点
	private int[] id;//强连通分量的标识符
	private int count;//强连通分量数量
	
	public KosarajuSCC(Digraph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];

		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for (int s : order.reversePost())
			if (!marked[s]) {
				dfs(G, s);
				count++;
			}
	}
	
	private void dfs(Digraph G,int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
	}
	
	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}

	public int count() {
		return count;
	}
}
