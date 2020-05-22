package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

	public static void main(String[] args) {
		// 后缀表达式  1-3*3-6
		String suffixExpression = "1 3 3 * - 6 -";
        //将表达式放入ArryList中
		List<String> list = getListString(suffixExpression);
		int res=calculate(list);
		System.out.println("结果是："+res);

	}

	public static List<String> getListString(String suffixExpression) {
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for (String item : split) {
			list.add(item);
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
