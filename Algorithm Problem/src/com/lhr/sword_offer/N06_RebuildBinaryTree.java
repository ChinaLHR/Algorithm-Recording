package com.lhr.sword_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>重建二叉树(根据前序遍历和中序遍历建立树)</h3>
 * 
 *          <pre>
 *          </pre>
 */
public class N06_RebuildBinaryTree {

	public static void main(String[] args) {
		String preOrder = "12473568";
		String midOrder = "47215386";
		/*
		 * 根据前序遍历（第一个值为根节点） 中序遍历（根节点左为左子树/根节点右为右子树）
		 */
		BiTree tree = new BiTree(preOrder, midOrder, preOrder.length());
		tree.postRootTraverse(tree.root);
	}
}

class BiTree {
	TreeNode root;

	/**
	 * @param preOrder 前序遍历结果
	 * @param midOrder 中序遍历结果
	 * @param count 树的结点数量
	 */
	public BiTree(String preOrder, String midOrder, int count) {
		if (count <= 0)
			return;
		char c = preOrder.charAt(0);//根节点
		int i = 0;//根节点在中序遍历的位置
		for (; i < count; i++) {
			if(midOrder.charAt(i) == c) break; 
		}
		
		root = new TreeNode(c);
		//设置左树结点
		root.setLchild(new BiTree(preOrder.substring(1,i+1), midOrder.substring(0,i),i).root);
		//设置右树结点
		root.setRchild(new BiTree(preOrder.substring(i+1), midOrder.substring(i+1), count-i-1).root);
	}
	
	/**
	 * 打印后序遍历结果
	 * @param root
	 */
	public void postRootTraverse(TreeNode root) {
		if(root!=null) {
			postRootTraverse(root.getLchild());	
			postRootTraverse(root.getRchild());
			System.out.println(root.getData());
		}
	}
}

class TreeNode {
	char data;
	TreeNode Lchild;
	TreeNode Rchild;

	public TreeNode(char data) {
		super();
		this.data = data;
	}

	public TreeNode(char data, TreeNode lchild, TreeNode rchild) {
		super();
		this.data = data;
		Lchild = lchild;
		Rchild = rchild;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public TreeNode getLchild() {
		return Lchild;
	}

	public void setLchild(TreeNode lchild) {
		Lchild = lchild;
	}

	public TreeNode getRchild() {
		return Rchild;
	}

	public void setRchild(TreeNode rchild) {
		Rchild = rchild;
	}
}