package com.lhr.sword_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>两个链表的公共结点</h3>
 * <pre>
 * 题目：输入两个单向链表，找出它们的第一个公共结点
 * 思路1：在第一个链表上遍历一遍，遍历过程中，在第二个链表上遍历查找与第一个链表重合的结点	[时间复杂度	O(nm)]
 * 思路2：如果单向链表有公共结点，那么这两个链表从某个结点开始，他们的m_pNext指向相同的结点，公共结点出现在两个链表的尾部
 * (使用栈数据结果，将两个链表的结点放入两个栈，这样两个链表的尾结点就位于两个栈的栈顶，接下来通过弹栈来比较获得公共结点)
 * [空间复杂度O(m+n) 时间复杂度O(m+n)——>使用了空间效率换取了时间效率]
 * 
 * 思路3:对于链表长度不一的控制,现在遍历两个链表得到他们的长度（长链表比短链表长n），在第二次遍历的时候在较长的链表上先走n步，接着在两个链表上遍历，
 * 找到第一个相同的结点就是公共节点。
 * [时间复杂度O(m+n) 节省了空间]
 * </pre>
 */
public class N37_LinkedCommonNode {

	public static void main(String[] args) {
		ListNode head1 = new ListNode();
		ListNode second1 = new ListNode();
		ListNode third1 = new ListNode();
		ListNode forth1 = new ListNode();
		ListNode fifth1 = new ListNode();
		ListNode head2 = new ListNode();
		ListNode second2 = new ListNode();
		ListNode third2 = new ListNode();
		ListNode forth2 = new ListNode();
		head1.nextNode = second1;
		second1.nextNode = third1;
		third1.nextNode = forth1;
		forth1.nextNode = fifth1;
		head2.nextNode = second2;
		second2.nextNode = forth1;
		third2.nextNode = fifth1;
		head1.data = 1;
		second1.data = 2;
		third1.data = 3;
		forth1.data = 6;
		fifth1.data = 7;
		head2.data = 4;
		second2.data = 5;
		third2.data = 6;
		forth2.data = 7;
		System.out.println(findFirstcommonNode(head1,head2).data);
	}
	
	private static ListNode findFirstcommonNode(ListNode head1,ListNode head2) {
		int len1 = getListLength(head1);
		int len2 = getListLength(head2);
		ListNode longListNode = null;
		ListNode shortListNode = null;
		int dif = 0;//长链表与短链表之间的长度差距
		//通过链表长度获取长链表与短链表
		if(len1>len2) {
			longListNode = head1;
			shortListNode = head2;
			dif = len1 - len2;
		}else {
			longListNode = head2;
			shortListNode = head1;
			dif = len2 - len1;
		}
		//长链表先走n步
		for (int i = 0; i < dif; i++) {
			longListNode = longListNode.nextNode;
		}
		//对链表进行遍历，因为两个链表的长度相等，遍历到相等的结点直接return
		while(longListNode!=null && shortListNode!=null&& longListNode != shortListNode) {
			longListNode = longListNode.nextNode;
			shortListNode = shortListNode.nextNode;
		}
		return longListNode;
	}
	
	/**
	 * 获取链表的长度
	 * @param head1
	 * @return
	 */
	private static int getListLength(ListNode head1) {
		int result = 0;
		if (head1 == null)
		return result;
		ListNode point = head1;
		while (point != null) {
			point = point.nextNode;
			result++;
		}
		return result;
	}
}

/**
 * 链表节点
 */
class ListNode{
	int data;
	ListNode nextNode;
}