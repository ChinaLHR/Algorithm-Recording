package io.github.chinalhr.sword_finger_offer;

import java.util.Stack;

/**
 *
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>二叉树中和为某一值的路径</h3>
 * <pre>
 * 题目：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * </pre>
 */
public class N25_TreeNodePrice {

	public static void main(String[] args) {
		BinaryTreeNode root=new BinaryTreeNode(10);
		BinaryTreeNode node1=new BinaryTreeNode(5);
		BinaryTreeNode node2=new BinaryTreeNode(4);
		BinaryTreeNode node3=new BinaryTreeNode(7);
		BinaryTreeNode node4=new BinaryTreeNode(12);
		root.setLchildNode(node1);root.setRchildNode(node4);
		node1.setLchildNode(node2);node1.setRchildNode(node3);
		findPath(root,22);
	}

	/**
	 * 实现思路：当前序遍历到某个节点的时候，使用stack记录路径，并累加结点路径的值，如果找到路径，则打印，找不到继续访问它的子结点，如果没有子结点了，
	 * 注意要把当前结点进行pop()
	 * @param root
	 * @param i
	 */
	private static void findPath(BinaryTreeNode root,int i) {

		if(root==null) return;
		//栈数据结构记录路径
		Stack<Integer> stack = new Stack<>();
		int currentSum = 0;
		findPath(root, i, stack, currentSum);

	}

	private static void findPath(BinaryTreeNode root, int i,
			Stack<Integer> stack, int currentSum) {
		currentSum += root.getData();
		stack.push(root.getData());
		//如果是叶结点并且值相等，打印路径
		if(root.getLchildNode()==null&&root.getRchildNode()==null) {
			if(currentSum == i) {
				System.out.println("找到路径");
				for (int path:stack) {
					System.out.println(path+" ");
				}
			}
		}

		//如果不是叶结点，则遍历它的子结点
		if(root.getLchildNode()!=null)
			findPath(root.getLchildNode(), i,stack,currentSum);

		if(root.getRchildNode()!=null)
			findPath(root.getRchildNode(),i,stack,currentSum);
		//弹出子节点
		stack.pop();
	}
}
