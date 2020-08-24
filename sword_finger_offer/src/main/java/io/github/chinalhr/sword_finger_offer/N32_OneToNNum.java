package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>从1到n整数中1出现的次数</h3>
 * <pre>
 * 题目： 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1的数字有1,10,11和12,1一共出现5次。
 * 解法1：直接遍历n个数,使用取余的方式获得1出现的次数,时间复杂度O(logn)
 * 解法2：根据规律总结
 * </pre>
 */
public class N32_OneToNNum {

	public static void main(String[] args) {
		System.out.println(countOne(115));
	}


	private static long countOne(int n) {
		long count =0;
		long i=1;
		long current=0,after=0,before=0;
		while((n/i)!=0){
			current=(n/i)%10;
			before=n/(i*10);
			after=n-(n/i)*i;

			if(current>1)
				count=count+(before+1)*i;
			else if(current==0)
				count=count+before*i;
			else if(current==1)
				count=count+before*i+after+1;
			i=i*10;
		}
		return count;
	}
}
