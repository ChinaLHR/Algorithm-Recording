package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>圆圈中最后剩下的数字（约瑟夫环问题）</h3>
 * <pre>
 * 题目：0~n-1这n个数字排列成一个圆圈， 从数字0开始每次从这个圆圈中删除第m个数字。 求出这个圆圈里剩下的最后一个数字
 * 思路一：采用环形链表模拟圆圈  [复杂度 O(logn)]
 * 思路二：分析每次被删除的数字规律并直接计算出圆圈中最后剩下的数字
 * 定义函数f(n,m),每次在n个元素中删除第m个元素最后剩下的数字
 *  k = (m-1)%n 记为k，表示第一个被删除的元素 ，删除k之后剩下n-1个元素，0，1，k-1，k，k+1...,下次删除从k+1开始计数
 *
 *  从规律中得知最后剩下的元素一定于m，n相关，可得到f(n,m)——>f(n-1,m)
 *  [复杂度 O(n)]
 * </pre>
 */
public class N45_LastNum {

	public static void main(String[] args) {
		System.out.println(lastRemaining(6, 3));
	}
	 public static int lastRemaining(int n,int m){
		 if(n<1||m<1)
		  return -1;
		 int last=0;
		 for(int i=2;i<=n;i++){
		  last=(last+m)%i;
		 }
		 return last;
		}
}
