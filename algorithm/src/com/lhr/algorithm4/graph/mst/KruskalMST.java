package com.lhr.algorithm4.graph.mst;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>Kruskal算法实现最小生成树的生成</h3>
 * <pre>
 * 优势：在图中存在相同权值的边时也有效
 * 主要思想：按权重顺序(从小到大)处理将边加入最小生成树(确保不会生成环),直到树中含有V-1条边为止
 * 
 * 实现：使用一个Queue维护mst,使用MinPQ维护所有的边，使用Union Find检测环
 * 将所有的边加入MinPQ，一次取出并删除权重最小边加入mst(需要判断是否形成环与进行分量合并)，直到mst含有V-1条边为止。
 * </pre>
 */
public class KruskalMST {
	
	private Queue<Edge> mst;

	public KruskalMST(EdgeWeightedGraph G) {
		mst = new Queue<>();
		MinPQ<Edge> pq = new MinPQ<>();
		for (Edge e : G.edges()) 
			pq.insert(e);
		
		UF uf = new UF(G.V());
		while (!pq.isEmpty()&&mst.size()<G.V()-1) {
			Edge e = pq.delMin();
			int v = e.either(),w = e.other(v);
			if (uf.connected(v, w))
				continue;//忽略失效的边
			uf.union(v, w);//合并分量
			mst.enqueue(e);//加入mst
		}
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	
}
