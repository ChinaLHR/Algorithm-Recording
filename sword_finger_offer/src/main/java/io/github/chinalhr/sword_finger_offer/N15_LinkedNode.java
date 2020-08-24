package io.github.chinalhr.sword_finger_offer;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 *          <h3>链表中倒数第k个结点</h3>
 *
 *          <pre>
 * 题目：输入一个链表，输出该链表中倒数第K个结点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1,2,3,4,5,6。
 * 这个链表的倒数第3个结点是值为4的结点。
 * （注意代码鲁棒性，考虑输入空指针，链表结点总数少于k，输入的k参数为0）
 *
 *
 *          </pre>
 */
public class N15_LinkedNode {
	public static void main(String[] args) {
		MyNode15 a = new MyNode15("1");
		MyNode15 b = new MyNode15("2");
		MyNode15 c = new MyNode15("3");
		MyNode15 d = new MyNode15("4");
		MyNode15 e = new MyNode15("5");
		MyNode15 f = new MyNode15("6");
		a.setNext(b);
		b.setNext(c);
		c.setNext(d);
		d.setNext(e);
		e.setNext(f);
		System.out.println(findDataFromTail(a, 2));
	}

	/**
	 * 输出链表的倒数第k个结点
	 *
	 * 实现思想：使用两个指针,第一个指针p1先移动k个结点，然后第二个指针p2再移动(p1与p2始终保持k-1的距离,当p1到达链表尾时，p2指向倒数第k个结点)
	 *
	 * @param a
	 * @param k
	 * @return
	 */
	private static String findDataFromTail(MyNode15 a, int k) {
		if (a == null)
			return null;
		if (k == 0) {
			System.out.println("k应该从1开始");
			return null;
		}

		MyNode15 node1 = a;
		MyNode15 node2 = null;
		for (int i = 0; i < k-1; i++) {
			if(node1.getNext()==null) {
				System.out.println("k不应该大于链表长度");
				return null;
			}
			node1 = node1.getNext();
		}
		node2 = a;

		while(node1.getNext()!=null) {
			node1 = node1.getNext();
			node2 = node2.getNext();
		}
		return node2.getData();

	}
}

class MyNode15 {
	private String data;
	private MyNode15 next;

	public MyNode15(String data) {
		super();
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public MyNode15 getNext() {
		return next;
	}

	public void setNext(MyNode15 next) {
		this.next = next;
	}

}
