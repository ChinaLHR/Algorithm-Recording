package com.lhr.algorithm4.test;

import org.junit.Assert;
import org.junit.Test;

import com.lhr.algorithm4.graph.Digraph;
import com.lhr.algorithm4.graph.Graph;
import com.lhr.algorithm4.graph.directed.DirectedDFS;
import com.lhr.algorithm4.graph.directed.KosarajuSCC;
import com.lhr.algorithm4.graph.undirected.BreadthFirstPaths;
import com.lhr.algorithm4.graph.undirected.CC;

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
