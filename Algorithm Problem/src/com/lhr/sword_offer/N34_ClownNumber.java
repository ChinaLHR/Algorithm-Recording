package com.lhr.sword_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>丑数</h3>
 * <pre>
 * 题目：我们把只包含因子2,3和5的数称作丑数。求按从小到大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7.习惯上我们把1当做第一个丑数。
 * (丑数只能被2，3，5整除)
 * 思路一：直接进行循环计算，从一开始，获取丑数直到第n个
 * 思路二：空间换时间的算法，创建一个数组，存储排好序的丑数，每一个丑数都是前面的丑数乘以2，3，5获得
 * 思路二的优势：不需要在非丑数的整数上进行计算，时间效率增加
 * 思路二的劣势：增加了空间消耗，如果是求第1500个丑数，将创建一个大小为1500的数组
 * </pre>
 */
public class N34_ClownNumber {

	public static void main(String[] args) {
		System.out.println(getUgly(1500));
	}
	
	private static int getUgly(int n) {
		if(n<0) return 0;
		int[] uglyArray = new int[n];
		uglyArray[0] = 1;//第一个丑数1
		int multiply2 = 0;
		int multiply3 = 0;
		int multiply5 = 0;
		/**
		 * 计算已排序数组：
		 * 通过计算下一个被2，3，5整除的丑数的最小数添加到数组中
		 */
		for (int i = 1; i < n; i++) {
			 int min = getMin(uglyArray[multiply2]*2,uglyArray[multiply3]*3,uglyArray[multiply5]*5);  
	         uglyArray[i] = min; 
	            while(uglyArray[multiply2]*2 == uglyArray[i])  
	                multiply2++;  
	            while(uglyArray[multiply3]*3 == uglyArray[i])  
	                multiply3++;  
	            while(uglyArray[multiply5]*5 == uglyArray[i])  
	                multiply5++;  
		}
		return uglyArray[n-1];
	}
	
	private static int getMin(int i, int j, int k) {
		int min=(i<j)?i:j;
		return (min<k)?min:k;
	}
}
