package io.github.chinalhr.sword_finger_offer;

import java.util.Arrays;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>扑克牌顺子</h3>
 * <pre>
 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字
 * 建模：5张牌——>数组
 *
 * 实现：
 * ①对数组进行排序
 * ②统计数组中0的个数
 * ③统计排序后数组中相邻数字之间的空缺总数，空缺总数小于等于0的个数，数组是连续的，反之不连续
 * </pre>
 */
@SuppressWarnings("unused")
public class N44_PlayingCard {

	public static void main(String[] args) {

	}

	private static boolean isContinuous(int[] arr) {

		if(arr==null || arr.length!=5)
			return false;

		Arrays.sort(arr);
		 int numberZero=0; //0的个数
		 int numberGap=0;//空缺总数
		 for(int i=0;i<arr.length&&arr[i]==0;i++)
			 numberZero++;

		 //统计排序后数组中相邻数字的空缺总数
		 int small = numberGap;
		 int big = small+1;
		 while(big<arr.length) {
			 if(arr[small] == arr[big])
				 numberGap+=arr[big]-arr[small]-1;
			 small=big;
			 big++;
		 }

		 return (numberGap>numberZero)?false:true;
	}
}
