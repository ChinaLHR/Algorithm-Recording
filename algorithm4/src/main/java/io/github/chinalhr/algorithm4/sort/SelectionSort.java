package io.github.chinalhr.algorithm4.sort;
/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *
 * <h3>选择排序:不断选择剩余元素中的最小者 </h3>
 *<pre>
 * 实现：找到数组中最小，将他与数组第一个元素交换位置（如果自己就是第一个元素，就与自己交换）。
 * 	       一次循环过后，再在剩下的元素中找到最小的元素，将他与数组第二个元素交换位置，依次往复。
 *
 * 缺陷：为了找出最小元素需要扫描一遍数组，并且不能为接下来的扫描提供信息。导致扫描一个已排序
 * 	         的数组与一个未排序的随机数组消耗时间一样。
 *
 * 复杂的:O(n2)
 * </pre>
 */
public class SelectionSort {
	public static void sort(int[] a) {
		//将a按升序排序
		for (int i = 0; i < a.length; i++) {
			int min = i;//最小元素索引
			for (int j = i+1; j < a.length; j++) {
				if (a[j]<a[min]) {
					min = j;
				}
				exch(a, min, j);
			}
		}
	}

	//交换索引
	private static void exch(int[] a,int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
