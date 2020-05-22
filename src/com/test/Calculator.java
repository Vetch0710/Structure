package com.test;

public class Calculator {

	public static void main(String[] args) {
		String expression = "1-3*3-6";
		Stack2 numstack = new Stack2(10);
		Stack2 operstack = new Stack2(10);
		int index = 0; // 索引 用于扫描
		int num1 = 0, num2 = 0, oper = 0, res = 0;
		char ch = ' ';
		while (true) {
			// 依次得到字符
			ch = expression.substring(index, index + 1).charAt(0);
			if (operstack.isOper(ch)) { // 判斷是否为运算符
				if (!operstack.isEmpty()) { // 判断栈是否为空

					if (operstack.priority(ch) <= operstack.priority(operstack.peek())) {
						// 当前符号优先级小于或等于栈顶元素的优先级
						num1 = numstack.pop();
						num2 = numstack.pop();
						oper = operstack.pop();
						res = numstack.cal(num1, num2, oper);
						numstack.push(res);
						operstack.push(ch);
					} else {
						operstack.push(ch);
					}
				} else {
					operstack.push(ch);
				}
			} else {
				// 扫描到的字符为数字
//				numstack.push(ch-48);
				int i = 1;
				String nnum = ch + "";

				if (index == expression.length() - 1) {
					numstack.push(Integer.parseInt(ch + ""));
				} else {
					while (true) {
						char nch = expression.substring(index + i, index + i + 1).charAt(0);
						if (operstack.isOper(nch)) {
//							System.out.println(nnum);
							numstack.push(Integer.parseInt(nnum + ""));
							index = index + i - 1;
							break;
						} else {
							nnum += nch;
							i++;
						}
					}

				}
			}
			index++;
			if (index >= expression.length()) {
				break;
			}
		}

		while (true) {
			if (operstack.isEmpty()) {
				break;
			}
			num1 = numstack.pop();
			num2 = numstack.pop();
			oper = operstack.pop();
//			if () {
//				
//			}
			if (oper == operstack.peek() && operstack.peek() == '-') {
				res = numstack.cal(num1, num2, '+');
			} else {
				res = numstack.cal(num1, num2, oper);
			}
			System.out.println(res);
			numstack.push(res);
		}
		System.out.println("结果为:" + numstack.pop());
	}

}

class Stack2 {
	int maxsize;
	int[] arr;
	int top = -1;

	public Stack2(int size) {
		maxsize = size;
		arr = new int[maxsize];
	}

	// 判断是否已满
	public boolean isFull() {
		return top == maxsize - 1;
	}

	// 判断是否为空
	public boolean isEmpty() {
		return top == -1;
	}

	// 进栈
	public void push(int num) {
		if (isFull()) {
			System.out.println("当前栈已满");
			return;
		}
		top++;
		arr[top] = num;
	}

	// 出栈
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("当前栈为空！");
		}
		int value = arr[top];
		top--;
		return value;
	}

	// 遍历输出栈
	public void list() {
		if (isEmpty()) {
			throw new RuntimeException("当前栈为空！");
		}
		for (int i = top; i >= 0; i--) {
			System.out.println(arr[i]);
		}

	}

	// 查看栈顶元素
	public int peek() {
		if (isEmpty()) {
			return 0;
		}
		return arr[top];
	}

//返回运算符的优先级，优先级是程序员来确定，优先级使用数字来表示
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1; // 假设表达式是有 + - * /
		}
	}

	// 判定是不是一个运算符
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}

	// 计算方法
	public int cal(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;

		default:
			break;
		}
		return res;
	}

}
