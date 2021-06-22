package io.github.chinalhr.leetcode.stack;

import io.github.chinalhr.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author lhr
 * @Date 2021/6/22
 * @Description: 题目：94. 二叉树的中序遍历 easy
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class BinaryTreeInorderTraversal {

    /**
     * 递归实现，简单易懂
     */
    private ArrayList<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        return doInorderTraversal(root);
    }

    public List<Integer> doInorderTraversal(TreeNode root){
        if (root == null) return result;
        doInorderTraversal(root.left);
        result.add(root.val);
        doInorderTraversal(root.right);
        return result;
    }

    /**
     * 非递归实现，利用栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}
