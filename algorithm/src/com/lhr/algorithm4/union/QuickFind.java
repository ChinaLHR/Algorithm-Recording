package com.lhr.algorithm4.union;
/**
 * 
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * QuickFind缺点：无法处理大数据，因为每次union都会连接整个数组
 * <br/>
 * 复杂度：O(n2)
 */
public class QuickFind {
	
	private int[] id;// 分量id(以触点为索引，值为分量)
	private int count;// 分量数量

	public QuickFind(int N) {
		// 初始化分量id数组
		this.count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	public int count() {
		return count;
	}
	
	//p所在分量的标识符
	public int find(int p) {
		return id[p];
	}

	/**
	 * 连通p q两个分量
	 * 
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		// 将p和q归并到相同点分量中
		int pID = find(p);
		int qID = find(q);
		// 如果p q已经在相同点分量中，return
		if (pID == qID)
			return;

		// 将p的分量重命名为q的名称
		for (int i = 0; i < id.length; i++)
			if (id[i] == pID)
				id[i] = qID;
		count--;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
}
