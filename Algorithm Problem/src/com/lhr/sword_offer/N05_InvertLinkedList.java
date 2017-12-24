package com.lhr.sword_offer;

import java.util.Stack;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR 
 * @content
 * <h3>反转链表（从尾到头打印链表）</h3>
 */
public class N05_InvertLinkedList {
	
	public static void main(String[] args) {
		Node node1=new Node("A");
		Node node2=new Node("B");
		Node node3=new Node("C");
		Node node4=new Node("D");
		Node node5=new Node("E");
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		Node newNode=reverseByStack(node1);
		while(newNode!=null){
			System.out.print(newNode.data+" ");
			newNode=newNode.getNext();
		}
	}
	
	/**
	 * 递归反转
	 * 实现思路：链表反转 ——> 后进先出  (栈) ——> 利用递归模拟栈
	 * 实现：先递归输出它后面的结点，再输出该结点自身
	 * @param head
	 * @return
	 */
	private static Node reverseByStack(Node head) {
		if(head.next == null) return head;
		Node reverseHead = reverseByStack(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);		
		return reverseHead;
	}
	
	/**
	 * 利用Stack反转
	 * 实现思路：使用栈存储正序遍历的链表结点，再用栈pop出来得到链表的反转
	 * @param head
	 * @return
	 */
	private static Node reverseByLoop(Node head) {
		Stack<Node> stack = new Stack<>();
		Node node = head;
		while(node!=null) {
			stack.push(node);
			node = node.getNext();
		}
		node = stack.pop();
		while(stack.isEmpty()) {
			node.setNext(stack.pop());
			node = node.getNext();
		}
		return node;
	}
	
}

class Node{
	String data;
	Node next;
	
	public Node(String data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public Node(String data) {
		super();
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
