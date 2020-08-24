package io.github.chinalhr.sword_finger_offer;

import java.util.Stack;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>用两个栈建立队列(实现在队列尾部插入节点/在队列头部删除结点)</h3>
 * <pre>
 * 实现：使用两个栈,向队列尾部加入数据时就向栈1压入数据,获取队列首部数据就是先将栈1 —压入—> 栈2 ，此时再从栈2弹出就是队列首部数据
 * </pre>
 */
public class N07_StackImplQueue {

	private Stack<Object> s1 = new Stack<>();
	private Stack<Object> s2 = new Stack<>();

	/**
	 * 向队列尾部插入元素
	 * @param x
	 */
	public void offer(Object x) {
		s1.push(x);
	}

	/**
	 * 获取并删除队列首部
	 */
	public void poll() {
		if(s1.size() == 0 && s2.size()==0) throw new RuntimeException("队列为空");
		else {
			//Stack2 不为空
			if(s2.size()!=0) {
				System.out.println(s2.peek().toString());
				s2.pop();
			}
			//Stack2为空,将Stack1的数据弹出并加入Stack2
			else {
				while(s1.size()>0) {
					s2.push(s1.pop());
				}
				System.out.println(s2.peek().toString());
				s2.pop();
			}

		}
	}

	public static void main(String[] args) {
		N07_StackImplQueue stack_queue = new N07_StackImplQueue();
		stack_queue.offer("A");
		stack_queue.offer("B");
		stack_queue.offer("C");
		stack_queue.poll();
		stack_queue.poll();
		stack_queue.poll();
		stack_queue.poll();
	}


}
