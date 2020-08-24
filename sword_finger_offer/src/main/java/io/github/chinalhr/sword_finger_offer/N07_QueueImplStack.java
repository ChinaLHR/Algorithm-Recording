package io.github.chinalhr.sword_finger_offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>用两个队列实现栈</h3>
 * <pre>
 * 实现：使用两个队列,栈push操作就向queue1加入数据,栈pop操作就由queue1删除队列头部元素并向加入queue2直到剩下一个元素，
 * 再从queue1删除队列头部元素(最后一个元素)完成pop操作
 * </pre>
 */
@SuppressWarnings("unused")
public class N07_QueueImplStack {

	private Queue<Object> queue1 = new ArrayDeque<>();
	private Queue<Object> queue2 = new ArrayDeque<>();

	/**
	 * 向栈顶插入数据
	 * @param s
	 */
	public void push(String s) {
		if(queue1.isEmpty()&&queue2.isEmpty())
			queue1.add(s);
		else if(!queue1.isEmpty())
			queue1.add(s);
		else queue2.add(s);

	}

	/**
	 * 获取并删除栈顶元素
	 * @return
	 */
	public String pop() {
		Queue<Object> tQueue;
		Queue<Object> oQueue;

		if(queue1.isEmpty()&&queue2.isEmpty())
			throw new RuntimeException("Stack is Null");

		if (!queue1.isEmpty()) { tQueue = queue1;oQueue = queue2;}
		else {tQueue = queue2;oQueue = queue1;}

		while(tQueue.size()>1)
		{
			oQueue.add(tQueue.remove());
		}

		return (String) tQueue.remove();
	}

	public static void main(String[] args) {
		N07_QueueImplStack stack = new N07_QueueImplStack();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
