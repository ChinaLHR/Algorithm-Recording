package com.lhr.algorithm4.sort;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>三向快速排序</h3>
 * <pre>
 * 实现：
 * 相比快速排序,在切分中维护a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
 * 优势：
 * 在出现大量重复元素的数组的情况下，相对于快速排序的速度有一定的提升，因为它切分时不会交换相等的元素。
 * </pre>
 */
public class Quick3waySort {

	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}


	 private static void sort(int[] a, int lo, int hi) {
	 if (hi <= lo)return;
	 int lt = lo,i = lo+1,gt = hi;
	 int v = a[lo];
	 while (i <= gt) {
		 if (a[i]>v) exch(a, lt++, i++);
		 else if(a[i]<v) exch(a, i, gt--);
		 else i++;
	 }
	 //a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立
	 sort(a, lo, lt-1);
	 sort(a, gt+1, hi);
	 }


	private static void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
