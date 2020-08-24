package io.github.chinalhr.algorithm4.graph.directed;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>基于DFS的顶点排序[拓扑排序的实现]</h3>
 *
 * <pre>
 * 基本思想：DFS只会访问每个节点一次
 * 前序，后序与逆后序
 *       0
 *     / | \
 *   5   1   6
 *   |
 *   4
 * 前序：[0 5 4 1 6]
 * 后序：[4 5 1 6 0]
 * 逆后序：[0 6 1 5 4]
 * </pre>
 */
public class DepthFirstOrder {

	private boolean[] marked;
	private Queue<Integer> pre; // 所有顶点的前序排列
	private Queue<Integer> post; // 所有顶点的后序排列
	private Stack<Integer> reversePost;// 所有顶点的逆后序排列

	public DepthFirstOrder(Digraph G) {
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<>();
		marked = new boolean[G.V()];

		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			if (!marked[v])
				dfs(G, v);
	}

	private void dfs(Digraph G, int v) {
		pre.enqueue(v);//dfs()的调用顺序
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
		post.enqueue(v);//顶点遍历完成的顺序
		reversePost.push(v);//后序的逆序
	}

	public Iterable<Integer> pre() {
		return pre;
	}

	public Iterable<Integer> post() {
		return post;
	}

	public Iterable<Integer> reversePost() {
		return reversePost;
	}
}
