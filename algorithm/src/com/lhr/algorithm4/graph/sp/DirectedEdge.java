package com.lhr.algorithm4.graph.sp;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>加权有向边数据结构</h3>
 */
public class DirectedEdge {
	
	private final int v; // 边的起点
	private final int w; // 边的终点
	private final double weight; // 边的权重
	
	public DirectedEdge(int v,int w,double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight() {
		return weight;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	public String toString() {
		return String.format("%d->%d %.2f", v, w, weight);
	}
}
