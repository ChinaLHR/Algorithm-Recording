package com.lhr.sword_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>复杂链表的复制</h3>
 * <pre>
 * 题目：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复制一个复杂链表。在复杂链表中，
 * 每个结点除了有一个m_pNext指针指向下一个结点外，还有一个m_pSibling指向链表中的任意结点或者NULL
 * </pre>
 */
public class N26_LinkedCopy {
	public static void main(String[] args) {
		ComplexListNode node1=new ComplexListNode(1);
		ComplexListNode node2=new ComplexListNode(2);
		ComplexListNode node3=new ComplexListNode(3);
		ComplexListNode node4=new ComplexListNode(4);
		ComplexListNode node5=new ComplexListNode(5);
		node1.next=node2;node2.next=node3;node3.next=node4;
		node4.next=node5;node1.sibling=node3;node2.sibling=node5;
		node4.sibling=node2;
		ComplexListNode result=clone(node1);
		while(result!=null){
			System.out.println(result.data);
			result=result.next;
		}
	}
	
	/**
	 * 进行复杂链表复制
	 * @param head
	 * @return
	 */
	private static ComplexListNode clone(ComplexListNode head) {
		cloneNodes(head);
		copySibingNodes(head);
		return separateNodes(head);
	}
	
	/**
	 * 第三步：把长链表拆分为两个链表(原链表与复制链表)，通过连接奇偶数位实现,返回复制链表
	 * @param head
	 * @return
	 */
	private static ComplexListNode separateNodes(ComplexListNode head) {
		ComplexListNode node=head;
		ComplexListNode cloneHead=null;//复制结点的头结点
		ComplexListNode cloneNode=null;//复制结点
		if(node!=null) {
			cloneNode = node.next;
			cloneHead = cloneNode;
			node.next = cloneNode.next;
			node = node.next;
		}
		while (node!=null) {
			cloneNode.next=node.next;
			cloneNode=cloneNode.next;
			node.next=cloneNode.next;
			node=node.next;
		}
		
		return cloneHead;
	}
	
	/**
	 * 第二步：设置复制出来的结点m_pSibling,N——>S,N'——>S'
	 * @param head
	 */
	private static void copySibingNodes(ComplexListNode head) {
		ComplexListNode node = head;
		while(node!=null) {
			ComplexListNode cloneNode = node.next;
			if(node.sibling!=null) cloneNode.sibling = node.sibling.next;
			node = cloneNode.next;
		}
	}
	
	/**
	 * 第一步：根据原始链表的每个结点N创建对应的N',把N’链接在N后面
	 * @param head
	 */
	private static void cloneNodes(ComplexListNode head) {
		ComplexListNode node = head;
		while(node!=null) {
			ComplexListNode cloneNode = new ComplexListNode(node.data);
			cloneNode.next = node.next;
			node.next = cloneNode;
			node = cloneNode.next;
		}
	}
}

/**
 * 复杂链表结点
 */
class ComplexListNode{
	int data;
	ComplexListNode next;
	ComplexListNode sibling;
	public ComplexListNode(int data) {
		super();
		this.data = data;
	}	
}
