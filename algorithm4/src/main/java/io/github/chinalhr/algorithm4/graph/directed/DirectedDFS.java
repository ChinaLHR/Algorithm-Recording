package io.github.chinalhr.algorithm4.graph.directed;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>基于DFS实现有向图可达性</h3>
 */
@SuppressWarnings("unused")
public class DirectedDFS {

	private boolean[] marked;

	public DirectedDFS(Digraph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	public DirectedDFS(Digraph G, Iterable<Integer> sources) {
		marked = new boolean[G.V()];
		for (int s : sources)
			if (!marked[s])
				dfs(G, s);
	}

	private void dfs(Digraph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
	}

	/**
	 * s——>v是否是可达的
	 * @param v
	 * @return
	 */
	public boolean marked(int v) {
		return marked[v];
	}

}
