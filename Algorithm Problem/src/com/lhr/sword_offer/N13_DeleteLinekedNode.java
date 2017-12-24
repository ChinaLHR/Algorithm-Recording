package com.lhr.sword_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>O(1)时间删除链表结点</h3>
 * <pre>
 * 题目：给定单向链表的头指针和一个结点指针， 定义一个函数在O（1）时间删除该节点
 * 
 * 删除思路：
 * 正常：从单向链表头开始顺序遍历,找到目标的前一个结点设置next为目标的next，删除目标结点(复杂度O(n))
 * 
 * 实现思路:把目标结点的下一个结点的内容复制到需要删除的结点上覆盖原来的内容，再把下一个结点删除
 * </pre>
 */
public class N13_DeleteLinekedNode {
	
	public static void main(String[] args) {
		MyNode a = new MyNode("A");
		MyNode b = new MyNode("B");
		MyNode c = new MyNode("C");
		MyNode d = new MyNode("D");
		a.setNext(b);b.setNext(c);c.setNext(d);
		
		MyNode temp = a;
		while(temp!=null){
			System.out.println(temp.getData());
			temp=temp.next;
		}
	}
	
	private static void delete(MyNode head,MyNode c) {
		//如果是尾节点,只能遍历删除
		if(c.next==null) {
			while(head.next!=c) {
				head = head.next;
			}
			head.next = null;
		}
		//如果只有一个节点，直接置为NULL
		else if(head == c) {
			head = null;
		//直接把当前结点设置为next结点并删除
		}else {
			c.setData(c.getNext().getData());
			c.setNext(c.getNext().getNext());
		}
	}
}
/*
 * 链表结点
 */
class MyNode{
	MyNode next;
	String data;
	public MyNode(String data) {
		super();
		this.data = data;
	}
	public MyNode getNext() {
		return next;
	}
	public void setNext(MyNode next) {
		this.next = next;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}