package io.github.chinalhr.algorithm4.test;

import io.github.chinalhr.algorithm4.graph.directed.Digraph;
import io.github.chinalhr.algorithm4.graph.directed.DirectedDFS;
import io.github.chinalhr.algorithm4.graph.directed.KosarajuSCC;
import io.github.chinalhr.algorithm4.graph.mst.Edge;
import io.github.chinalhr.algorithm4.graph.mst.EdgeWeightedGraph;
import io.github.chinalhr.algorithm4.graph.mst.KruskalMST;
import io.github.chinalhr.algorithm4.graph.sp.DijkstraSP;
import io.github.chinalhr.algorithm4.graph.sp.DirectedEdge;
import io.github.chinalhr.algorithm4.graph.sp.EdgeWeightedDigraph;
import io.github.chinalhr.algorithm4.graph.undirected.BreadthFirstPaths;
import io.github.chinalhr.algorithm4.graph.undirected.CC;
import io.github.chinalhr.algorithm4.graph.undirected.Graph;
import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

	@Test
	public void DFSTest() {
		BreadthFirstPaths dfs = new BreadthFirstPaths(getGraph(), 0);
		Assert.assertTrue(dfs.hasPathTo(4));
		Iterable<Integer> path = dfs.pathTo(4);
		for (Integer i : path)
			System.out.println(i);
	}

	@Test
	public void DirectedTest() {
		DirectedDFS dfs = new DirectedDFS(getDigraph(), 0);
		Assert.assertTrue(dfs.marked(3));
	}

	@Test
	public void CCTest() {
		CC cc = new CC(getGraph());
		Assert.assertTrue(cc.connected(0, 4));
	}

	@Test
	public void SCCTest() {
		KosarajuSCC scc = new KosarajuSCC(getDigraph());
		Assert.assertTrue(scc.stronglyConnected(0, 4));
	}

	/**
	 * 最小生成树测试
	 */
	@Test
	public void MSTTest() {
		KruskalMST mst = new KruskalMST(getEWG());
		for (Edge e : mst.edges()) {
			System.out.println(e);
		}
	}

	/**
	 * 最短路径测试
	 */
	@Test
	public void SPTest() {
		DijkstraSP sp = new DijkstraSP(getEWD(), 0);
		Iterable<DirectedEdge> pathTo = sp.pathTo(4);
		for (DirectedEdge e : pathTo) {
			System.out.println(e);
		}
	}

	private EdgeWeightedDigraph getEWD() {
		EdgeWeightedDigraph g = new EdgeWeightedDigraph(6);
		g.addEdge(new DirectedEdge(0, 1, 7));
		g.addEdge(new DirectedEdge(0, 2, 9));
		g.addEdge(new DirectedEdge(0, 5, 14));
		g.addEdge(new DirectedEdge(1, 2, 10));
		g.addEdge(new DirectedEdge(1, 3, 15));
		g.addEdge(new DirectedEdge(2, 5, 2));
		g.addEdge(new DirectedEdge(2, 3, 11));
		g.addEdge(new DirectedEdge(3, 4, 6));
		g.addEdge(new DirectedEdge(5, 4, 9));
		return g;
	}

	private EdgeWeightedGraph getEWG() {
		EdgeWeightedGraph graph = new EdgeWeightedGraph(7);
		graph.addEdge(new Edge(0, 1, 6));
		graph.addEdge(new Edge(0, 2, 1));
		graph.addEdge(new Edge(0, 3, 5));
		graph.addEdge(new Edge(1, 2, 5));
		graph.addEdge(new Edge(2, 3, 5));
		graph.addEdge(new Edge(1, 4, 3));
		graph.addEdge(new Edge(3, 5, 2));
		graph.addEdge(new Edge(2, 4, 6));
		graph.addEdge(new Edge(2, 5, 4));
		graph.addEdge(new Edge(4, 5, 6));
		return graph;
	}

	private Graph getGraph() {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		return graph;
	}

	private Digraph getDigraph() {
		Digraph digraph = new Digraph(5);
		digraph.addEdge(0, 1);
		digraph.addEdge(1, 4);
		digraph.addEdge(1, 2);
		digraph.addEdge(2, 3);
		digraph.addEdge(3, 4);
		digraph.addEdge(4, 0);
		return digraph;
	}
}
