package io.github.chinalhr.leetcode.base;

/**
 * @Author: lihanrong
 * @Date: 2020/8/28 5:06 下午
 * @Description:
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
