package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>合并两个排序的链表</h3>
 * <pre>
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中结点仍然是按照递增排序的。例如输入1->3->5->7和2->4->6->8，
 * 则合并之后的升序链表应该是1->2->3->4->5->6->7->8 。
 * </pre>
 */
public class N17_MergeLineked {

	public static void main(String[] args) {
		Node17 node1=new Node17(1);
		Node17 node2=new Node17(3);
		Node17 node3=new Node17(5);
		Node17 node4=new Node17(7);
		node1.setNext(node2);node2.setNext(node3);node3.setNext(node4);
		Node17 node5=new Node17(2);
		Node17 node6=new Node17(4);
		Node17 node7=new Node17(6);

		node5.setNext(node6);node6.setNext(node7);
		Node17 head=merge(node1,node5);
		while(head!=null){
			System.out.print(head.getData()+" ");
			head=head.getNext();
		}
	}

	/**
	 * 实现思路：对两个链表的首结点进行比较，取出小的结点添加到临时链表中，循环此操作直到一方的Next()为NULL，
	 * 就将剩下的链表中的结点都添加到链表中，注意对NULL链表的处理
	 * @param a
	 * @param b
	 * @return
	 */
	private static Node17 merge(Node17 a,Node17 b) {
		if(a==null && b==null) return null;
		if(a==null) return b;
		if(b==null) return a;

		/**
		 * 获取首首节点
		 */
		Node17 head = a.getData()>b.getData()?b:a;
		Node17 index1 = head.getNext();
		Node17 index2 = head==a?b:a;

		/**
		 * 对两个链表的首结点进行判断
		 */
		while (index1!=null&&index2!=null) {
			if(index1.getData()<index2.getData()) {
				head.setNext(index1);
				index1 = index1.getNext();
			}else {
				head.setNext(index2);
				index2 = index2.getNext();
			}
			head = head.getNext();
		}

		/**
		 * 在某个链表为NULL的情况下进行设置
		 */
		if(index1==null) {
			while(index2!=null) {
				head.setNext(index2);
				index2 = index2.getNext();
				head = head.getNext();
			}
		}else {
			while(index1!=null) {
				head.setNext(index1);
				index1 = index1.getNext();
				head = head.getNext();
			}
		}

		return a.getData()>b.getData()?b:a;
	}
}

class Node17{
	int data;
	Node17 next;

	public Node17(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node17 getNext() {
		return next;
	}
	public void setNext(Node17 next) {
		this.next = next;
	}
}
