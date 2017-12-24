package com.lhr.sword_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>连续子数组的最大和</h3>
 * <pre>
 * 题目：输入一个整型数组，数组里有正数，也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n）
 * 
 * 例如{1，-2，3，10，-4，7，2，-5}的连续子数组的最大和是{3,10,-4,7,2}
 * 解法1：举例分析数组规律(累加规律,根据累加的结果是否小于原数值决定是否加入子数组集合)
 * 解法2：基于动态规划实现
 * </pre>
 */
public class N31_SubarraySum {
	
	public static void main(String[] args) {
		int[] arr={1,-2,3,10,-4,7,2,-5};
		System.out.println(maxSub(arr));
	}
	
	private static int maxSub(int[] arr) {
		int max=0;
		int n=arr.length;
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=arr[i];
			if(sum>max)
				max=sum;
			else if(sum<0)
				sum=0;
		}
		return max;
		
	}
	
}
