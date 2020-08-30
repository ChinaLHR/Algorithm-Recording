package io.github.chinalhr.leetcode.linked_list;

import io.github.chinalhr.leetcode.base.ListNode;

/**
 * @Author lhr
 * @Date 2020/8/30
 * @Description: 61. 旋转链表 medium
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 实现：
 * 1.  形成环型链表
 * 3. 使用快慢指针找到倒数第k个节点
 * 2. 找到断开点（倒数第k-1个链表Node）,链表表头（倒数第K个链表Node）
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        if (k==0||head==null||head.next ==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tailNode = dummy;
        ListNode first = dummy;
        ListNode second = dummy;


        //1. 形成环型链表
        while(tailNode.next!= null){
            tailNode = tailNode.next;
        }

        tailNode.next = head;

        //2. 找到断开点（倒数第k-1个链表Node）,链表表头（倒数第K个链表Node）
        for (int i = 0; i < k ; i++) {
            first = first.next;
        }

        while (first.next != tailNode){
            first =first.next;
            second = second.next;
        }

        ListNode disconnectNode = second.next;
        ListNode headNode = second.next.next;
        disconnectNode.next = null;
        return headNode;
    }

}
