package io.github.chinalhr.algorithm4.graph.undirected;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *  <h3>基于广度优先算法的(最短路径)路径寻找</h3>
 */
@SuppressWarnings("unused")
public class BreadthFirstPaths {

	private boolean[] marked;//标记顶点
	private int[] edgeTo;//到达该顶点的已知路径的最后一个顶点
	private final int s;

	public BreadthFirstPaths(Graph G,int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	/**
	 * <pre>
	 * 实现思路:
	 * ①使用一个队列来保存所有已经被标记过但其邻接表还未被检查过的顶点。(先将起点加人队列)
	 * ①取队列中的下一个顶点v并标记它.
	 * ②将与v相邻的所有未被标记过的顶点加人队列。
	 * </pre>
	 * @param G
	 * @param s
	 */
	private void bfs(Graph G,int s) {
		Queue<Integer> queue = new Queue<>();
		marked[s] = true;//标记顶点
		queue.enqueue(s);//加入队列中
		while(!queue.isEmpty()) {
			int v = queue.dequeue();//从队列中删除并取出下一个顶点
			for(int w : G.adj(v))
				if (!marked[w]) {
					edgeTo[w] = v;// 保存最短路径的最后一条边
					marked[w] = true;// 标记他，因为最短路径已知
					queue.enqueue(w);// 并将它添加到队列中
				}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	/**
	 * s到v的路径，如果不存在则返回null
	 *
	 * @param v
	 * @return
	 */
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
}
