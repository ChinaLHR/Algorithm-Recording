package com.lhr.sword_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>数组中的逆序对</h3>
 * <pre>
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字， 则这两个数字组成一个逆序对。 输入一个数组，求出这个数组中的逆序对的总数
 * 思路一：扫描整个数组，逐个比较数字与其后面的数字	需要两层遍历	[复杂度 O(n2)]
 * 思路二：先把数组分隔成子数组，先统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组之间的逆序对的数目，统计逆序对的过程中需要对数组进行排序
 * [实际上就是归并排序 ][复杂度O(nlogn),当需要空间消耗，临时数组]
 * </pre>
 */
public class N36_ArrayReversedTwain {
	
	public static void main(String[] args) {
		int[] arr = { 7, 5, 6, 4 };
		System.out.println(getInversePairs(arr));
	}

	private static int getInversePairs(int[] arr) {
		if (arr == null)
			return 0;
		int[] clone = arr.clone();
		return mergeSort(arr, clone, 0, arr.length - 1);
	}
	
	private static int mergeSort(int[] array, int[] result, int start, int end) {
		if (start == end) {
			result[start] = array[start];
			return 0;
		}
		int length = (end - start) / 2;
		int left = mergeSort(result, array, start, start + length);
		int right = mergeSort(result, array, start + length + 1, end);
		int leftIndex = start + length;
		int rightIndex = end;
		int count = 0;
		int point = rightIndex;
		while (leftIndex >= start && rightIndex >= start + length + 1) {
			if (array[leftIndex] > array[rightIndex]) {
				result[point--] = array[leftIndex--];
				count += rightIndex - start - length;

			} else {
				result[point--] = array[rightIndex--];
			}
		}
		for (int i = leftIndex; i >= start; i--)
			result[point--] = array[i];
		for (int j = rightIndex; j >= start + length + 1; j--)
			result[point--] = array[j];
		return left + right + count;
		
	}
	
}
