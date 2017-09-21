package com.lhr.algorithm4.sort;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>希尔排序</h3> 
 * <pre>
 * 实现：	先将整个待排元素序列分割成若干个子序列（由相隔某个“增量h”的元素组成的）
 *		分别进行直接插入排序，然后依次缩减增量再进行排序，待整个序列中的元素基本有序（增量足够小）时，
 *		再对全体元素进行一次直接插入排序。
 * 
 * 对插入排序的优化：因为插入排序对于大规模乱序数组排序很慢，在分割排序之后，数组大部分是有序的，在这种情况下插入排序效率很高。
 * <pre>
 */
public class ShellSort {

	public static void sort(int[] a) {
		int N = a.length;
		int h = 1;
		// 1，4，13...
		while (h < N / 3)
			h = 3 * h + 1;
		// 进行插入排序将数组变成h有序
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}

	public static void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = j;
		a[j] = t;
	}

}
