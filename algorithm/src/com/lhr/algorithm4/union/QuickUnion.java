package com.lhr.algorithm4.union;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * quick-union利用树形数据结构，利用find()查找树，union()将归并两棵树。
 * <br/>
 * 树这种数据结构容易出现极端情况，因为在建树的过程中，树的最终形态严重依赖于输入数据本身的性质，比如数据是否排序，是否随机分布等等。
 * <br/>
 * 缺陷：可能会将大树链接到小树上，导致树的高度过高
 * <br/>
 * 算法复杂度：O(n)-O(n2)
 * 
 * 实现：index:链接数1 value:链接数1的链接数
 */
public class QuickUnion {

	private int[] id;// 分量id(以触点作为索引)
	private int count;

	public QuickUnion(int N) {
		// 初始化分量id数组
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public int count() {
		return count;
	}
	
	/**
	 * 从给定触点开始，由他的链接得到另一个触点，依次反复，直到找到根触点，既链接指向根除点。
	 * 
	 * a——>b——>c  find(a) = c
	 * 
	 * @param p
	 * @return
	 */
	public int find(int p) {
		// 找出分量的名称
		while (p != id[p])
			p = id[p];
		return p;
	}
	
	/**
	 * 输入p , q分别找到他们的根触点，只需将一个根触点指向另一个。 
	 * @param p
	 * @param q
	 */
	public void union(int p,int q) {
		//将p和q的根节点统一
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) 
			return;
		id[pRoot] = qRoot;
		count--;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
}
