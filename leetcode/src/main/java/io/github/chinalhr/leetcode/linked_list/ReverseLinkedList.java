package io.github.chinalhr.leetcode.linked_list;

import io.github.chinalhr.leetcode.base.ListNode;

/**
 * @Author lhr
 * @Date 2021/7/12
 * @Description: 206. 反转链表 easy
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current!=null){
            ListNode next = current.next;
           current.next = prev;
           prev = current;
           current = next;
        }
        return prev;
    }

}
