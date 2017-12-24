package com.lhr.sword_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>二叉树的后序遍历序列</h3>
 * <pre>
 * 题目：
 *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同
 * </pre>
 */
public class N24_TreeePilogue {
	
	public static void main(String[] args) {
			int[] array={5,7,6,9,11,10,8};
			boolean b=verfiySequenceOfBST(array,0,6);
			System.out.println(b);
	}
	
	/**
	 * 实现原理：根据规律，后序遍历结果最后一个数字是根节点的值,数组可以分成两部分,第一部分左子树结点的值，他们都比根节点小，
	 * 第二部分右子树结点的值，他们都比根节点大
	 * [递归实现]
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private static boolean verfiySequenceOfBST(int[] array,int start ,int end) {
		//进行数组大小判断
		if(array==null||start>end||start<0||end<0)
			return false;
		
		//对于只有一个结点的树的判断
		if(start==end)
			return true;
		
		int root=array[end];
		
		//在二叉搜索树中左子树的结点小于根节点
		int i=start;
		for(;i<=end;i++){
			if(array[i]>root)
				break;
		}
		
		//在二叉搜索树中右子树的结点大于根节点
		int j=i;
		for(;j<=end;j++){
			if(array[j]<root)
				return false;
		}
		
		//判断左子树是不是二叉搜索树
		boolean left=true;
		if(i>start)
			left=verfiySequenceOfBST(array,start,i-1);
		
		
		//判断右子树是不是二叉搜索树
		boolean right=true;
		if(i<end)
			right=verfiySequenceOfBST(array,i,end-1);
		
		return (left&&right);
	}
}
