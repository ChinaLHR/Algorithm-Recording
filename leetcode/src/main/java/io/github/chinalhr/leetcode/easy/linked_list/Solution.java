package io.github.chinalhr.leetcode.easy.linked_list;

/**
 * @Author: lihanrong
 * @Date: 2020/8/28 4:18 下午
 * @Description: 题目：141. 环形链表
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 进阶：
 * 能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 实现：
 * 设置两个指针，一个每次走一步的【慢指针】和一个每次走两步的【快指针】。
 * - 如果不含有环，跑得快的那个指针最终会遇到 null，说明链表不含环
 * - 如果含有环，快指针会超慢指针一圈，和慢指针相遇，说明链表含有环。
 */
public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
