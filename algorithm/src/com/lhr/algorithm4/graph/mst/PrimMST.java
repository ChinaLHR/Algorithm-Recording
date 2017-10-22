package com.lhr.algorithm4.graph.mst;
/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>Prim算法实现最小生成树的生成（即时实现）</h3>
 * <pre>
 * 即时实现：在优先队列中只会存储每个非树顶点w和树顶点的边中权重最小的边，避免每次都要检查边的有效性与删除边
 * 
 * 实现思路：
 * 使用Edge[]维护最小生成树的边，double[]维护最小生成树权重，IndexMinPQ维护有效横切边，
 * 选取顶点0添加到PQ中,【删除并取出PQ中权重最小的边,将邻边权重最小的添加到最小生成树数组并插入到PQ中】依次往复
 * </pre>
 */

import java.util.Iterator;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>Prim算法实现最小生成树的生成（即时实现）</h3>
 *
 */
@SuppressWarnings("unused")
public class PrimMST {
	
	private Edge[] edgeTo;//距离树最近的边，维护整颗最小生成树
	private double[] distTo;//distTo[w] = edgeTo[w].weight
	private boolean[] marked;//如果v在树中则marked[v] = true
	private IndexMinPQ<Double> pq;//有效的横切边
	
	public PrimMST(EdgeWeightedGraph G) {
		//初始化数据结构
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0;v<G.V();v++) 
			distTo[v] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.V());
		
		distTo[0] = 0.0;
		pq.insert(0, 0.0);//用顶点0和权重0初始化pq
		while(!pq.isEmpty())
			visit(G, pq.delMin());//将最近的顶点添加到树中
	}
	
	/**
	 * 遍历所有邻节点，将他们加入pq(最小权重)
	 * @param G
	 * @param v
	 */
	@SuppressWarnings("deprecation")
	private void visit(EdgeWeightedGraph G,int v) {
		//将顶点v添加到树中，更新数据
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			int w = e.other(v);
			if (marked[w]) continue;//v-w失效
			//循环获取最小权重边生成树
			if (e.weight()<distTo[w]) {
				//连接w和树的最佳边Edge变为e
				edgeTo[w] = e;
				distTo[w] = e.weight();
				//键存在于队列则修改值，不存在则插入
				if (pq.contains(w)) pq.change(w, distTo[w]);
				else pq.insert(w, distTo[w]);
			}
		}
	}
	
	public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }

}
