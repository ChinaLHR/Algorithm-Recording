package io.github.chinalhr.leetcode.stack;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author lhr
 * @Date 2021/7/14
 * @Description: 150 . 逆波兰表达式求值 medium
 * 根据 逆波兰表示法，求表达式的值。 有效的算符包括+、-、*、/。
 * 每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明： 整数除法只保留整数部分。 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * <p>
 * 实现：
 * 基于一个栈实现，具体见代码
 * </p>
 */
public class EvaluateReversePolishNotation {

    private static Set<String> symbol = new HashSet();

    public int evalRPN(String[] tokens) {
        symbol.add("+");symbol.add("-");symbol.add("*");symbol.add("/");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            boolean isSymbol = symbol.contains(tokens[i]);
            if (!isSymbol){
                stack.push(Integer.parseInt(tokens[i]));
            }else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                switch (tokens[i]){
                    case "+": {
                        stack.push(num1 + num2);
                        break;
                    }
                    case "-": {
                        stack.push(num1 - num2);
                        break;
                    }
                    case "*": {
                        stack.push(num1 * num2);
                        break;
                    }
                    case "/": {
                        stack.push(num1 / num2);
                        break;
                    }
                }
            }
        }
        return stack.pop();
    }
}
