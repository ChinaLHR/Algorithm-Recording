package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>不用加减乘除做加法</h3>
 * <pre>
 * 写一个函数，求两个整数之和，要求函数体内部不能使用+、-、*、\四则与符号
 *
 * 思路：
 * 进行二进制三步操作：
 * ①相加不进位——>异或操作
 * ②几下进位——>位与+左移
 * ③转换为十进制
 * </pre>
 */
public class N47_AddOperation {

	public static void main(String[] args) {
		System.out.println(add(5, 19));
	}

	private static int add(int num1,int num2) {

		int sum,carry;
		do {
			sum = num1^num2;
			carry = (num1&num2)<<1;
			num1 = sum;
			num2 = carry;
		}while(num2!=0);
		return num1;
	}

}
