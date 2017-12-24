package com.lhr.sword_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>树的子结构</h3>
 * <pre>
 * 输入两颗二叉树A和B，判断B是不是A的子结构
 * </pre>
 */
public class N18_JudgeTree {
	
	public static void main(String[] args) {
		BinaryTreeNode node1=new BinaryTreeNode(8);
		BinaryTreeNode node2=new BinaryTreeNode(8);
		BinaryTreeNode node3=new BinaryTreeNode(7);
		BinaryTreeNode node4=new BinaryTreeNode(9);
		BinaryTreeNode node5=new BinaryTreeNode(2);
		BinaryTreeNode node6=new BinaryTreeNode(4);
		BinaryTreeNode node7=new BinaryTreeNode(7);
		node1.setLchildNode(node2);node1.setRchildNode(node3);
		node2.setLchildNode(node4);node2.setRchildNode(node5);
		node5.setLchildNode(node6);node5.setRchildNode(node7);
		
		BinaryTreeNode a=new BinaryTreeNode(8);
		BinaryTreeNode b=new BinaryTreeNode(9);
		BinaryTreeNode c=new BinaryTreeNode(2);
		a.setLchildNode(b);a.setRchildNode(c);
		System.out.println(hasSubTree(node1,a));
	}
	
	/**
	 * 实现：
	 * 递归{
	 * ①在树A中找到和B根节点的值一样的结点R
	 * ②判断A树中以R为根节点的子树是不是包含和树B一样的结构
	 * ③如果不包含树B一样的结构,继续递归左节点与右节点
	 * }
	 * @param root1
	 * @param root2
	 * @return
	 */
	private static boolean hasSubTree(BinaryTreeNode root1,BinaryTreeNode root2) {
		boolean result = false;
		//找到某个结点跟子树的根结点一致
		if(root1!=null&&root2!=null) {
			if(root1.getData()==root2.getData()){
				result = doseTree1HaveTree2(root1, root2);
				if(!result) 
					result = hasSubTree(root1.getLchildNode(), root2);
				
				if(!result) 
					result = hasSubTree(root1.getRchildNode(),root2);
			}
		}
		return result;
		
	}
	
	/**
	 * 对A树中的某个结点的子树与B树进行判断
	 * [进行递归判断]
	 * @param root1
	 * @param root2
	 * @return
	 */
	@SuppressWarnings("unused")
	private static boolean doseTree1HaveTree2(BinaryTreeNode root1,
			BinaryTreeNode root2) {
		if(root2==null)
			return true;
		if(root1==null)
			return false;
		if(root1.getData()!=root2.getData())
			return false;
		
		return doseTree1HaveTree2(root1.getLchildNode(), root2.getLchildNode())&&
				doseTree1HaveTree2(root1.getRchildNode(), root2.getRchildNode());
	}
	
}
