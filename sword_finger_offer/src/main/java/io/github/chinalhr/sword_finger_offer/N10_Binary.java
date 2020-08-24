package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>二进制中1的个数</h3>
 * <pre>
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制是1001， 有2位是1。因此如果输入9，该函数输出2。
 * </pre>
 */
public class N10_Binary {

	public static void main(String[] args) {
		System.out.println(getNumberOf1Beta(9));
	}


	private static int getNumberOf1(int n) {
		int num=0;
		while(n!=0){
			num++;
			n=(n-1)&n;
		}
		return num;
	}

	private static int getNumberOf1Beta(int n) {
		 int count = 0;
	        int flag = 1;
	        while(flag <= n){
	        	//①将整数n与1进行与运算，当整数n最低位是1时，则结果非零，否则结果为0。
	            if((n&flag) != 0)
	                count++;
	            //②然后将1左移一位，继续与n进行与运算，当次低位是1时，结果非零，否则结果为0。
	            flag = flag<<1;
	        }
	        //③统计二进制中1的个数
	        return count;
	}

}
