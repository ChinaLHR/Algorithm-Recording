package io.github.chinalhr.algorithm4.sort;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *<h3>归并排序</h3>
 * 思想：分治
 */
public class MergeSort {
	private static int[] aux;

	/**
	 * <h4>自底向上的归并排序</h4>
	 *<pre>
	 *
	 *实现：数组中先一个一个归并成两两有序的序列，两两有序的序列归并成四个四个有序的序列，然后四个四个有序的序列归并八个八个有序的序列，
	 *以此类推，直到，归并的长度大于整个数组的长度
	 *
	 * 示例：【数据量 8】
	 *lo:0==mid:0==hi:1
	 *lo:2==mid:2==hi:3
	 *lo:4==mid:4==hi:5
	 *lo:6==mid:6==hi:7
	 *=================
	 *lo:0==mid:1==hi:3
	 *lo:4==mid:5==hi:7
	 *=================
	 *lo:0==mid:3==hi:7
	 * </pre>
	 * @param a
	 */
	public static void sortDownToUp(int[] a) {
		aux = new int[a.length];
		int N = a.length;
		//sz：设定子数组大小 [1,2,4,8...]
		for (int sz = 1; sz < N; sz=sz*2)
			//归并子数组 ,确定各个子数组中lo mid hi的索引
			for (int lo = 0; lo <N-sz; lo+=sz*2) {
				int mid = lo+sz-1;
				//最后一位可能会越界，所以在此取最小数
				int hi = Math.min(lo+(sz*2)-1, N-1);
				merge(a, lo, mid, hi);
			}
	}

	/**
	 * <h4>自顶向下的归并排序</h4>
	 * 实现：通过对数组的拆分/合并，通过层层拆分得到单元数组，此时单元数组是有序的，然后通过归并两个单元数组得到大数组，然后再归并大数组得到更大的有序数组，
	 * 以此往复，最终得到一个有序数组。
	 * <br/><br/>
	 * 优化：
	 * <ul>
	 * <li>①对小规模数组使用插入排序</li>
	 * <li>②判断数组是否有序，有序则跳过merger</li>
	 * <li>③不将元素复制到辅助数组</li>
	 * </ul>
	 * @param a
	 */
	public static void sortUpToDown(int[] a) {
		aux = new int[a.length];
		sortUpToDown(a, 0, a.length - 1);
	}

	private static void sortUpToDown(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sortUpToDown(a, lo, mid);// 将左半部分排序
		sortUpToDown(a, mid + 1, hi);//将右半部分排序
		merge(a, lo, mid, hi);//归并结果
	}

	/**
	 * 原地归并：将数组中两个不同的有序部分a[lo..mid],a[mid+1..hi]进行排序 <br/>
	 * <br/>
	 * 从lo与mid+1对比左右边的数值,如果左边取尽了就直接取右边的，反之亦然。
	 *
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(int[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		// Copy a[lo..hi] 到 aux[lo..hi]
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		// 归并回到a[lo..hi]
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];// 左半边用尽，取右半边
			else if (j > hi)
				a[k] = aux[i++];// 右半边用尽，取左半边
			else if (aux[i] > aux[j])
				a[k] = aux[j++];// 右半边的当前元素小于左半边的当前元素，取右半边
			else
				a[k] = aux[i++];// 左半边的当前元素小于右半边的当前元素，取左半边
		}
	}

	public static void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = j;
		a[j] = t;
	}

}
