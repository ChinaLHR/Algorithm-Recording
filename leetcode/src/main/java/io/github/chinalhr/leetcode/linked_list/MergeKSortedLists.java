package io.github.chinalhr.leetcode.linked_list;

import io.github.chinalhr.leetcode.base.ListNode;

/**
 * @Author lhr
 * @Date 2020/8/30
 * @Description: 题目：23. 合并K个升序链表 hard
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 实现：
 * 1. 基于MergeTwoSortedLists，实现两个升序排列的链表合并
 * 2. 基于分治合并的思想（自顶向下的归并排序），通过对数组的拆分/合并，通过层层拆分得到单元链表，
 *  此时单元链表是有序的，然后通过归并两个单元链表——>再归并大链表得到更大的有序链表，最终得到结果
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftList = merge(lists, left, mid);
        ListNode rightList = merge(lists, mid + 1, right);
        return mergeTwoLists(leftList, rightList);

    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
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
        return prehead.next;
    }
}
