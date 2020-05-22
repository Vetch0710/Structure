package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Infix_suffix {

	public static void main(String[] args) {
		String infixExpression = "1+((2+3)*4)-5";
		// 将表达式放入ArryList中
		List<String> list = getListString(infixExpression);
		list = paeseSuffix(list);
		int res=calculate(list);
		System.out.println(list);
		System.out.println(res);
	}

	public static List<String> getListString(String s) {
		List<String> list = new ArrayList<String>();
		int i = 0;
		String str = "";
		char c = ' ';
		do {
			if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				list.add("" + c);
				i++;
			} else {
				str = "";
				while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
					str += c;
					i++;
				}
				list.add(str);
			}
		} while (i < s.length());
		return list;
	}

	// 判断优先级
	public static int priority(String oper) {
		if (oper.equals("*") || oper.equals("/")) {
			return 1;
		} else if (oper.equals("+") || oper.equals("-")) {
			return 0;
		} else {
			return -1; // 假设表达式是有 + - * /
		}
	}

	public static List<String> paeseSuffix(List<String> s) {

		Stack<String> stack = new Stack<String>(); // 存储运算符
		// 因为第二个栈 不需要出栈而且还需要逆序输出 所以可以使用ArrayList代替
		// Stack<String> stack2 = new Stack<String>();
		List<String> list = new ArrayList<String>(); // 存放最后的元素表达式
		for (String item : s) {
			if (item.matches("\\d+")) {
				list.add(item);
			} else if (item.equals("(")) {
				stack.push(item);
			} else if (item.equals(")")) {
				while (!stack.peek().equals("(")) {
					list.add(stack.pop());
				}
				stack.pop();// 将匹配到的左括号 扔掉
			} else {
				while (stack.size() != 0 && priority(item) <= priority(stack.peek())) {
					list.add(stack.pop());
				}
				stack.push(item);
			}
		}
		while (stack.size() != 0) {
			list.add(stack.pop());
		}

		return list;
	}
	
	
	public static int calculate(List<String> list) {
		Stack<String> stack = new Stack<String>();
		for (String item : list) {
			if (item.matches("\\d+")) {
//				System.out.println(item);
				stack.push(item);
			} else {
//				System.out.println(item);
				int num1 = Integer.parseInt(stack.pop());
				int num2 = Integer.parseInt(stack.pop());
				int res = 0;
				if (item.equals("+")) {
					res = num1 + num2;
				} else if (item.equals("-")) {
					res = num2 - num1;
				} else if (item.equals("*")) {
					res = num1 * num2;
				} else if (item.equals("/")) {
					res = num2 / num1;
				}else {
					throw new RuntimeException("运算符有错");
				}
				stack.push(res+"");
			}
		}
		
		return  Integer.parseInt(stack.pop());
	}

	
	

}
