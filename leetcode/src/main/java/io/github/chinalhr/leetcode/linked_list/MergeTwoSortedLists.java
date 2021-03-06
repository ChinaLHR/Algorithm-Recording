package io.github.chinalhr.leetcode.linked_list;

import io.github.chinalhr.leetcode.base.ListNode;

/**
 * @Author lhr
 * @Date 2020/8/30
 * @Description: 题目：21. 合并两个有序链表 easy
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 实现：
 * 首先设置一个初始节点（init-node），它的next节点为返回的链表head节点
 * 通过循环合并，每次比较出连个链表中较小的节点，设置到init-node下，直到其中一个链表为空，把init-node节点的next指向
 * 剩下的不为空的链表，完成合并
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //合并后 l1 和 l2 最多只有一个还未被合并完，直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

}
