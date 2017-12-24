package com.lhr.sword_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>数组中只出现一次的数字</h3>
 * <pre>
 * 题目：	一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度O(1)
 * 
 * 思路：
 * 异或运算：任何一个数异或他自己结果都是0
 * </pre>
 */
public class N40_AppearOnceNumber {
	
	public static void main(String[] args) {
		 int[] array={2,4,3,6,3,2,5,5}; 
		 findNumsAppearOnce(array); 
	}

	private static void findNumsAppearOnce(int[] array) {
		if(array==null)
			return ;
		int num=0;
		for(int i:array){
			num^=i;
		}
		int index=findFirstBitIs1(num);
		int number1=0;
		int number2=0;
		for(int i:array){
			if(isBit1(i,index))
				number1^=i;
			else
				number2^=i;
		}
		System.out.println(number1);
		System.out.println(number2);
	}

	private static boolean isBit1(int number, int index) {
		number=number>>index; 
		return (number&1)==0; 
	}

	private static int findFirstBitIs1(int num) {
		int index=0;
		while((num&1)==0){
			num=num>>1;
			index++;
		}
		return index;
	}
}
