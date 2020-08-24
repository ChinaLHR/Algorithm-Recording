package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>打印1到最大的n位数</h3>
 * <pre>
 * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999
 * </pre>
 */
public class N12_MaxNum {

	public static void main(String[] args) {
		printNum(5);
	}


	/**
	 * 实现思路：把所有的数字前面补零的话，n位十进制实际上是n个从0到9的全排列,只需要把每一位的0到9遍历一遍就可以得到结果
	 * @param n
	 */

	private static void printNum(int n) {
		if(n<0)
			return;
		int[] array=new int[n];
		printArray(array,0);
	}

	private static void printArray(int[] array,int n) {
		if(n!=array.length){
			for(int i=0;i<10;i++){
				array[n]=i;
				printArray(array, n+1);
			}
		}
		else{
			boolean flag=false;
			for(int j=0;j<array.length;j++){
				if(array[j]!=0){
					flag=true;
				}
				if(flag){
					System.out.print(array[j]);
				}
			}
			if(flag)    //去掉空白行
			System.out.println();
		}
	}

}
