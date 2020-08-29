package io.github.chinalhr.leetcode.easy.linked_list;

import io.github.chinalhr.leetcode.base.ListNode;

/**
 * @Author: lihanrong
 * @Date: 2020/8/28 4:59 下午
 * @Description: 题目： 19. 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 实现：
 * 定位链表的倒数第 n 个节点
 * 1. 使用两个指针，先前进第一个指针n步，再并行前进第一个和第二个指针，当第一个指针到达尾结点时，第二个指针为倒数第n个节点
 * 2. 此时对第二个指针在链表的倒数第 n 个节点，删除目标节点（对其next节点进行修改）
 * 返回头节点
 * 1. 首先创建一个节点a，设置next为目标链表的头节点，进行节点删除后通过获取a的next得到链表的头结点
 */
public class LinkedListDeleteNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // 前进第一个指针，使第一个和第二个指针之间的间隔是n个节点
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // 第一个指针移动到最后，此时第二个指针的节点为
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
