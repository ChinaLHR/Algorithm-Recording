package com.lhr.sword_offer;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>从上往下打印二叉树（层序遍历二叉树）</h3>
 * <pre>
 * 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印
 * </pre>
 */
public class N23_TopToBottomPrintTree {
	
	public static void main(String[] args) {
		BinaryTreeNode node1=new BinaryTreeNode(8);
		BinaryTreeNode node2=new BinaryTreeNode(6);
		BinaryTreeNode node3=new BinaryTreeNode(10);
		BinaryTreeNode node4=new BinaryTreeNode(5);
		BinaryTreeNode node5=new BinaryTreeNode(7);
		BinaryTreeNode node6=new BinaryTreeNode(9);
		BinaryTreeNode node7=new BinaryTreeNode(11);
		node1.setLchildNode(node2);node1.setRchildNode(node3);
		node2.setLchildNode(node4);node2.setRchildNode(node5);
		node3.setLchildNode(node6);node3.setRchildNode(node7);
		
		printFromTopToBottom(node1);
	}
	
	/**
	 * 实现：使用中间容器Queue存储过度的结点,通过对Queue的入队与出队达到层序遍历
	 * @param root
	 */
	private static void printFromTopToBottom(BinaryTreeNode root) {
		if (root==null) return;
		Queue<BinaryTreeNode>  queue= new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode node = queue.poll();
			System.out.println(node.getData());
			if(node.getLchildNode()!=null) queue.add(node.getLchildNode());
			if(node.getRchildNode()!=null) queue.add(node.getRchildNode());
		}
	}
	
}
