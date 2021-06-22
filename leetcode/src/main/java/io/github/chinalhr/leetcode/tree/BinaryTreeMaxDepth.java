package io.github.chinalhr.leetcode.tree;

import io.github.chinalhr.leetcode.base.TreeNode;

import java.util.ArrayDeque;

/**
 * @Author lhr
 * @Date 2021/6/22
 * @Description: 题目：104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 实现：利用BFS，层层搜索，记录深度
 * </p>
 */
public class BinaryTreeMaxDepth {

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root==null){
            return maxDepth;
        }else {
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0 ; i < size;i++){
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }

}
