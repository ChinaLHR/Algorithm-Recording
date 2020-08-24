package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>二叉树深度</h3>
 * <pre>
 * 题目：输入一颗二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 思路：考察对树深度的概念转换,使用递归实现
 * </pre>
 */
public class N39_BinaryTreeDepth {

	public static void main(String[] args) {

	}

	public static Integer getTreeDepth(BinaryTreeNode root) {
		if(root==null) return null;
		int left = getTreeDepth(root.getLchildNode());
		int right = getTreeDepth(root.getRchildNode());

		return left>right?++left:++right;
	}

}
