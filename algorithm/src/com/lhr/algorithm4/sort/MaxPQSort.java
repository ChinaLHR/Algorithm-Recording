package com.lhr.algorithm4.sort;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * 
 *  <h3>堆排序</h3>
 * 
 */
public class MaxPQSort {

	private static int N = 0;
	
	/**
	 * 使用数组构建堆的构建：
	 * 从最后一个非叶节点（N/2）到根节点1逐个扫描所有节点并向下沉，直到当前结点为根节点完成堆的构建
	 * 
	 * 堆的排序：把堆的顶点与最后一个元素交换，在进行下沉操作（delMax操作），当所有元素都进行一次下沉操作时，整个数组是有序的
	 * @param a
	 */
	public static void sort(int[] a) {
		//构建堆
		N = a.length-1;
		for (int i = N/2; i >=0; i--) 
			sink(a,i);
		//对堆进行排序
		while (N>=0) {
			exch(a, 0, N--);
			sink(a, 0);
		}
	}
	

	/**
	 * 由上至下的堆有序化(下沉)
	 * <pre>
	 * 实现：不断地将节点与两个子节点中大的比较，如果大于子节点，则交换
	 * </pre>
	 * @param k
	 */
	private static void sink(int[] pq,int k) {
		while (2*k<=N) {
			int j = 2*k;
			if (j<N&&pq[j]<pq[j+1])
				j++;
			if (!(pq[k]<pq[j]))
				break;
			exch(pq,k, j);
			k = j;
		}
	}
	
	private static void exch(int[] pq,int i, int j) {
		int t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
}
