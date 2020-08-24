package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>斐波那契数列</h3>
 * <pre>
 * 题目：写一个函数，输入n，求斐波那契数列的第n项
 * 	   /	0	n=0
 * f(n)-	1	n=1
 * 	   \f(n-1)+f(n-2) n>1
 * </pre>
 */
public class N09_Fibonacci {

	public static void main(String[] args) {
		long l = fibonacci2(50);
		System.out.println("fibonacci 50 :"+l);
	}

	/**
	 * 斐波那契数列循环实现(O(n) , 不会出现多余的计算)
	 * @param n
	 * @return
	 */
	private static long fibonacci2(int n) {
		long[] a = {0,1};
		if(n<2)
			return a[n];

		long fib1 = 0,fib2 = 1,fibN = 0;
		for (int i = 2; i <= n; i++) {
			fibN = fib1 + fib2;
			fib1 = fib2;
			fib2 = fibN;
		}
		return fibN;
	}

	/**
	 * 斐波那契数列递归实现(效率极低,出现多余运算)
	 * @param n
	 * @return
	 */
	private static long fibonacci1(long n) {
		if(n<=0) return 0;
		if(n==1) return 1;
		return fibonacci1(n-1) + fibonacci1(n-2);
	}
}
