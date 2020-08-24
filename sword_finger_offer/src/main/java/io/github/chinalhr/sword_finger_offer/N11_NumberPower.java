package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>计算数值的整数次方</h3>
 * <pre>
 * 题目：实现函数double Power(double base,int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * </pre>
 */
public class N11_NumberPower {


	public static void main(String[] args) {
		System.out.println(Power(2.0, 3));
}
public static double Power(double base,int exponent) {
	if(exponent==0)
		return 1;
	if(exponent==1)
		return base;

	double result=Power(base, exponent>>1);
	result *=result;
	if((exponent&0x1)==1){
		result*=base;
	}
	return result;
}
}
