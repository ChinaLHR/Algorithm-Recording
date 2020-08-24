package io.github.chinalhr.sword_finger_offer;

import java.util.Stack;

/**
 *
 * @author Chinalhr
 * @email 13435500980@163.com
 * @github https://github.com/ChinaLHR
 * @content
 * <h3>栈的压入/弹出序列</h3>
 * <pre>
 *
 * </pre>
 */
public class N22_StackOrder {

	public static void main(String[] args) {
		Integer[] pushOrder={1,2,3,4,5};
		Integer[] popOrder={4,5,3,1,2};
		System.out.println(isRight(pushOrder,popOrder,5));
	}

	/**
	 * 实现原理：
	 * ①使用一个辅助栈,如果下一个弹出的数字刚好是栈顶数字，直接弹出
	 * ②如果下一个弹出的数字不在栈顶，把压栈序列中的数字压入辅助栈，直到找到数字为止
	 * ③把所有数字都压入栈仍没有找到数字，返回false
	 * @param pushOrder
	 * @param popOrder
	 * @param n
	 * @return
	 */
	private static boolean isRight(Integer[] pushOrder, Integer[] popOrder, int n) {
		Stack<Integer> stack = new Stack<>();
		int count = 0;
		for (int i = 0; i < popOrder.length; i++) {
			//刚好是栈顶元素，弹出
			if(!stack.isEmpty()&&stack.peek()==popOrder[i])
				stack.pop();
			else{
				//所有元素都压入辅助栈都没有找到要弹出的元素，输出错误
				if(count==pushOrder.length)
					return false;
				else {
					//不是栈顶元素，将压栈序列中的其他数字压入辅助栈
					do{
						stack.push(pushOrder[count++]);
					}
					while(stack.peek()!=popOrder[i]&&count!=pushOrder.length);
					if(stack.peek()==popOrder[i])
						stack.pop();
					else{
						return false;
					}
				}
			}
		}
		return true;
	}
}
