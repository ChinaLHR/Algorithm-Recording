package io.github.chinalhr.sword_finger_offer;

/**
 *
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>最大堆</h3>
 *
 */
@SuppressWarnings("unchecked")
public class MyMaxPQ<Key extends Comparable<Key>> {

	private Key[] pq;//基于堆的完全二叉树
	private int N = 0;

	public MyMaxPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN+1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	/**
	 * 删除最大元素操作
	 * @return
	 */
	public Key delMax() {
		Key max = pq[1];//从根节点获取最大的元素
		exch(1, N--);//将其和最后一个结点交换
		pq[N+1] = null;//防止越界
		return max;
	}

	/**
	 * 插入操作
	 * @param v
	 */
	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}

	/**
	 * 由下至上的堆有序化
	 * @param k
	 */
	private void sink(int k) {
		while(2*k <= N) {
			int j = 2*k;
			if(j < N && less(j, j+1)) j++;
			if(!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}

	/**
	 * 由上至下的堆有序化(堆的下沉操作)
	 * @param k
	 */
	private void swim(int k) {
		while(k>1&&less(k/2,k)) {
			exch(k/2, k);
			k = k/2;
		}
	}

	/**
	 * 对数据进行比较
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean less(int i,int j) {
		return pq[i].compareTo(pq[j])<0;
	}

	/**
	 * 对数据进行交换
	 * @param i
	 * @param j
	 */
	private void exch(int i,int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

}
