package com.lhr.algorithm4.graph.undirected;

import com.lhr.algorithm4.graph.Graph;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>连通分量</h3>
 *          <pre>
 *          实现原理:基于顶点索引数组 id[],如果v属于第i个连通分量,则id[v] = i,如此重复直到所有的顶点都被标记并区分 
 *          </pre>
 */
@SuppressWarnings("unused")
public class CC {

	private boolean[] marked;
	private int id[];
	private int count;

	public CC(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		//①使用以顶点作为索引的数组id[ ]，将同一个连通分量用int值关联起来。
		//②遍历所有顶点的dfs，用id[ x ] 把同相连的顶点用同一个count值关联  （id[ x ] = count）
		for (int s = 0; s < G.V(); s++)
			if (!marked[s]) {
				dfs(G, s);
				count++;
			}
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
	}
	
	/**
	 * v和w连通吗
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
	
	/**
	 *  v所在的连通分量的标识符
	 * @param v
	 * @return
	 */
	public int id(int v) {
		return id[v];
	}
	/**
	 * 连通分量数     
	 * @return
	 */
	public int count() {
		return count;
	}

}
