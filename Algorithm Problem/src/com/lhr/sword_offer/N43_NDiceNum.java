package com.lhr.sword_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>n个骰子的点数</h3>
 * <pre>
 * 题目： 把n个骰子仍在地上，所有骰子朝上一面的点数之和为s，输入n，打印出s的所有可能的值出现的概率
 * 
 * 建模：骰子数值为1-6，n个骰子的最小值为n，最大值为6n
 * 
 * 思路一：基于递归求出骰子的点数(时间复杂度高)
 * （先把骰子分成两堆,第一堆为1个，第二堆为n-1个,计算单独那一个可能出现的点数）<—— 再在第二堆中进行以上操作，递归的结束条件是第二堆只剩下一个骰子
 * 
 * 思路二：使用两个数组来存储骰子点数的每一个总数出现的次数
 * arr1:骰子和为n出现的次数	arr2:前一个数组对应的骰子数
 * </pre>
 */
public class N43_NDiceNum {

	public static void main(String[] args) {
		printProbability(2);
	}

	private static void printProbability(int num) {
		if(num<1)
			return;
		int gMaxValue=6;
		int[][] probabilities=new int[2][];
		//存储骰子点数之和
		probabilities[0]=new int[gMaxValue*num+1]; 
		probabilities[1]=new int[gMaxValue*num+1]; 
		int flag=0;
		//初始化骰子和
		for(int i=1;i<=gMaxValue;i++){
			probabilities[flag][i]=1;
		}
		for(int k=2;k<=num;k++){
			for(int i=0;i<k;i++){ 
			    probabilities[1-flag][i]=0; 
			   } 
			for(int i=k;i<=gMaxValue*k;i++){ 
			    probabilities[1-flag][i]=0; 
			    for(int j=1;j<=i&&j<=gMaxValue;j++)   
			 probabilities[1-flag][i]+=probabilities[flag][i-j]; 
		}
			 flag=1-flag;
		
	}
		double total=Math.pow(gMaxValue, num);for(int i=num;i<=gMaxValue*num;i++){ 

			   double ratio=(double)probabilities[flag][i]/total; 

			   System.out.print(i+" "); 

			   System.out.println(ratio); 
	
	}
	}
}
