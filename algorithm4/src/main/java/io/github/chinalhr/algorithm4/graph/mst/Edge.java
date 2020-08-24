package io.github.chinalhr.algorithm4.graph.mst;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>加权边数据结构的实现</h3>
 */
public class Edge implements Comparable<Edge>{

	private final int v;//顶点之一
	private final int w;//另一个顶点
	private final double weight;//边的权重

	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	/**
	 * 返回权重
	 * @return
	 */
	public double weight() {
		return weight;
	}
	/**
	 * 边两端的顶点之一
	 * @return
	 */
	public int either() {
		return v;
	}

	/**
	 * 返回另一个顶点
	 * @param vertex
	 * @return
	 */
	public int other(int vertex) {
		if (vertex == v)
			return w;
		else if (vertex == w)
			return v;
		else
			throw new RuntimeException("Inconsistent edge");
	}


	@Override
	public int compareTo(Edge that) {
		if (this.weight()< that.weight())
			return -1;
		else if (this.weight() > that.weight)
			return 1;
		else
			return 0;
	}

	public String toString() {
		return String.format("%d-%d %.2f", v, w, weight);
	}

}
