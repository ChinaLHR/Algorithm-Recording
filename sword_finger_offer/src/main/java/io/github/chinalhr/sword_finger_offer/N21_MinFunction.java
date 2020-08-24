package io.github.chinalhr.sword_finger_offer;

import java.util.Stack;

/**
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>包含min函数的栈</h3>
 * <pre>
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push以及pop的时间复杂度都是O(1)。
 * 实现原理：使用一个辅助栈栈顶保存最新的最小数。
 * 操作：
 * ①每次push的时候将栈与辅助栈进行对比，如果压入数据比stackHelp的peek()小,就直接压入stackHelp，否则直接压入stackHelp栈顶数据(保证stackHelp的栈顶是最小数)
 * ②每次pop的时候对栈与辅助栈实现同时的pop()，保证辅助栈最小数的正确性
 * ③min()函数直接从辅助栈中peek()获取最小数,复杂度为O(1)
 * </pre>
 */
public class N21_MinFunction {

	public static void main(String[] args) {
		MyStack a=new MyStack();
		a.push(10);
		a.push(11);
		a.push(4);
		a.push(6);
		a.push(3);
		System.out.println(a.min());
		a.pop();
		System.out.println(a.min());
		a.pop();
	}

}

class MyStack{
	private Stack<Integer> stack1,stackHelp;

	public MyStack() {
		stack1 = new Stack<>();
		stackHelp = new Stack<>();
	}

	/**
	 * 压栈操作
	 * @param mun
	 */
	public void push(int num) {
		stack1.push(num);
		//如果压入数据比stackHelp的peek()小,就直接压入stackHelp，否则直接压入stackHelp栈顶数据(保证stackHelp的栈顶是最小数)
		if(stackHelp.size()==0||num<stackHelp.peek())
			stackHelp.push(num);
		else
			stackHelp.push(stackHelp.peek());
	}

	/**
	 * 弹栈操作
	 */
	public void pop() {
		Integer pop1 = stack1.pop();
		Integer popHelp = stackHelp.pop();
		System.out.println("pop - stack1   ： " +pop1 +" ; pop - stackHelp : " +popHelp);
	}

	/**
	 * 弹出栈的最小元素
	 * @return
	 */
	public Integer min() {
		if(stackHelp.size()==0) {
			return null;
		}
		return stackHelp.peek();
	}


}
