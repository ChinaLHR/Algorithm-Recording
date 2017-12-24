package com.lhr.sword_offer;

import java.util.stream.Stream;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>找出最小的K个数</h3>
 * <pre>
 * 题目：输入n个整数，输出其中最小的k个。 
 * 例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4。 
 * 
 * 实现方式：
 * 思路1：基于快速排序的方式，设置切点位K，K左边的数字就是所需的数——>O(n)——>缺点：会修改输入的数据
 * 思路2：建立一个容量为k的容器存储最小的数，遍历读取数组的数据，在遍历读取一个数后，与容器里的最大数比较，如果小于则替换最大值加入容器中——>O(logn)——>不会修改输入的数据，适合海量数据的输入
 * 		容器数据结构适合使用最大堆来构建
 * </pre>
 */
public class N30_FindKMinNum {
	
	public static void main(String[] args) {
		 int array[] = {1,3,4,2,7,8,9,10,14,16};  
		 int[] kArray = getKArray(3, array);
		for (int i : kArray) {
			System.out.print(i+",");;
		}
	}
	
	private static int[] getKArray(int k,int[] arr) {
		
		MyMaxPQ<Integer> pq = new MyMaxPQ<>(k);
		int[] karr = new int[k];
		
		for (int i = 0; i < arr.length; i++) {
			if(pq.size()==k) {
				int max = pq.delMax();
				if(max>arr[i]) pq.insert(arr[i]);
				else pq.insert(max);
			}else {
				pq.insert(arr[i]);
			}
		}
		
		//此时pq = [3,2,0,1]
		for (int i = 0; i < pq.size(); i++) {
			int max = pq.delMax();
			karr[i] = max;
		}
		
		return karr;
	}
	
}
