package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>镜像二叉树</h3>
 * <pre>
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像
 * 实现：通过画图总结二叉树镜像过程
 * ①前序遍历这棵树的每个结点
 * ②如果遍历到的结点有子结点，就交换它的两个子结点
 * ③当交换完所有的非叶子结点左右子结点后，完成镜像二叉树
 *
 * </pre>
 */
public class N19_MirrorTree {

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
		mirror(node1);
		print(node1);
	}

	/**
	 * 打印二叉树
	 * @param root
	 */
	private static void print(BinaryTreeNode root) {
		if(root!=null){
			System.out.println(root.getData());
			print(root.getLchildNode());
			print(root.getRchildNode());
		}
	}

	/**
	 * 对二叉树进行镜像化
	 * @param root
	 */
	private static void mirror(BinaryTreeNode root) {
		if(root==null) return;

		if(root.getLchildNode()==null&&root.getRchildNode()==null) return;

		//交换左右子结点
		BinaryTreeNode temp = root.getLchildNode();
		root.setLchildNode(root.getRchildNode());
		root.setRchildNode(temp);
		mirror(root.getLchildNode());
		mirror(root.getRchildNode());
	}
}
