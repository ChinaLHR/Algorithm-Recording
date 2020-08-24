package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>调整数组的顺序使奇数位于偶数前面</h3>
 * <pre>
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * </pre>
 */
public class N14_AdjustArray {

	public static void main(String[] args) {
		int[] array={3,7,4,8,23,56,77,89,46,11,66,77};
		convert1(array);
		for (int i : array) {
			System.out.print(i+",");
		}
	}

	/**
	 * 实现方式1：使用两个指针，pleft指针从0开始记录偶数,pright指针从size()-1开始记录奇数,通过遍历数组对两指针的数值进行交换达到排序
	 * @param arr
	 */
	private static void convert1(int[] arr) {
		int pleft = 0;//左指针记录偶数
		int pright = arr.length-1;//右指针记录奇数
		while (pleft<pright) {
			//向右移动pleft,直到遇到偶数
			while (pleft<pright && arr[pleft]%2!=0)
				pleft++;

			//向左移动pright，直到遇到奇数
			while (pleft<pright && arr[pright]%2==0)
				pright--;

			if (pleft < pright) {
				int temp = arr[pleft];
				arr[pleft] = arr[pright];
				arr[pright] = temp;
			}
		}
	}

	/**
	 *
	 * @param arr
	 */
	private static void convert2(int[] arr) {

	}
}
