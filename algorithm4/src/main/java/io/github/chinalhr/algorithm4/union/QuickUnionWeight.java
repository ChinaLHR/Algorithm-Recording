package io.github.chinalhr.algorithm4.union;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * 加权的QuickUnion：添加一个数组记录树的节点数，总是size小的树作为子树和size大的树进行合并。这样就能够尽量的保持整棵树的平衡。
 */
public class QuickUnionWeight {

	private int[] id;// 分量id(以触点作为索引)
	private int[] sz;// 各个根节点对应的分量的大小
	private int count;// 分量数量

	public QuickUnionWeight(int N) {
		// 初始化分量id数组
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;

		// 初始情况下，每个组的大小都是1
		for (int i = 0; i < N; i++)
			sz[i] = 1;
	}

	public int count() {
		return count;
	}

	public int find(int p) {
		while (p != id[p])
			p = id[p];
		return p;
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot)
			return;

		// 将小树的根节点连接到大树的根节点
		if (sz[pRoot] < sz[qRoot]) {
			id[pRoot] = qRoot;
			sz[pRoot] += sz[qRoot];
		} else {
			id[qRoot] = pRoot;
			sz[qRoot] += sz[pRoot];
		}
		count--;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

}
