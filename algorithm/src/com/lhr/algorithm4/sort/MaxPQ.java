package com.lhr.algorithm4.sort;

/**
 * 
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>堆——优先队列</h3>
 * 
 *          <pre>
 * 关于堆：所有父节点比子节点小，称为最小堆，反之为最大堆。
 * 关于优先队列：支持删除最大/小元素于插入元素的数据结构。
 * 堆的实现：数组映射实现
 * 使用堆实现优先队列优势：与普通队列实现相比，寻找最大元素与插入元素不需要枚举整个数据结构，能应用与需要大量混杂的插入与删除最大元素操作的典型应用
 * 
 * 
 *          </pre>
 */
public class MaxPQ {
	
	/**
	 * 例如数组：[6,5,4,3,2]
	 * 		6
	 * 	   / \
	 * 	  5   4
	 *   /\
	 *  3  2  
	 */
	private int[] pq;// 基于堆的完全二叉树 
	private int N = 0;// 储存于pq[0..N]中

	public MaxPQ(int maxN) {
		pq = new int[maxN+1];
	}

	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	/**
	 * 插入元素：从底部插入元素并上浮
	 * @param v
	 */
	public void insert(int v) {
		pq[++N] = v;
		swim(N);
	}
	
	/**
	 * 删除最大的元素
	 * @return
	 */
	public int delMax() {
		int max = pq[0];//从根节点获得最大的元素
		exch(0, N--);//将其和最后一个节点交换
		sink(0);
		return max;
	}
	
	/**
	 * 由下至上的堆有序化(上浮)
	 * <pre>
	 * 实现：不断地将节点与父节点比较，如果节点大于父节点，则交换节点,直到k=0到达根节点
	 * </pre>
	 * @param k
	 */
	private void swim(int k) {
		while (k>0&&pq[k/2]<pq[k]) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	/**
	 * 由上至下的堆有序化(下沉)
	 * <pre>
	 * 实现：不断地将节点与两个子节点中大的比较，如果大于子节点，则交换
	 * </pre>
	 * @param k
	 */
	private void sink(int k) {
		while (2*k<=N) {
			int j = 2*k;
			if (j<N&&pq[j]<pq[j+1])
				j++;
			if (!(pq[k]<pq[j]))
				break;
			exch(k, j);
			k = j;
		}
	}
	
	private void exch(int i, int j) {
		int t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
}
