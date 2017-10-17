package com.lhr.algorithm4.graph.directed;

/**
 * 
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>拓扑排序实现</h3>
 */
public class Topological {
	private Iterable<Integer> order; // 顶点的拓扑顺序

	public Topological(Digraph G) {
		DirectedCycle cyclefinder = new DirectedCycle(G);
		//判断是否存在环
		if (!cyclefinder.hasCycle()) {
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}

	public Iterable<Integer> order() {
		return order;
	}

	public boolean isDAG() {
		return order == null;
	}

}