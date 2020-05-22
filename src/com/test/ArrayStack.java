package com.test;

public class ArrayStack {

	public static void main(String[] args) {
		Stacks stack = new Stacks(5);
	        stack.push(1);
	        stack.push(2);
	        stack.push(3);
	        stack.push(4);
	        stack.push(5);
	        System.out.println("栈内元素：");
	        stack.list();
	        System.out.println("第一次移出"+stack.pop());
	        System.out.println("第二次移出"+stack.pop());
	        System.out.println("移出后的栈元素:");
	        stack.list();

	}

}
class Stacks {
    int maxsize;
    int[] arr;
    int top = -1;

    public Stacks(int size) {
        maxsize = size;
        arr = new int[maxsize];
    }

    //判断是否已满
    public boolean isFull() {
        return top == maxsize - 1;
    }

    //判断是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //进栈
    public void push(int num) {
        if (isFull()) {
            System.out.println("当前栈已满");
            return;
        }
        top++;
        arr[top] = num;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("当前栈为空！");
        }
        int value = arr[top];
        top--;
        return value;
    }
    //遍历输出栈
    public void list(){
        if(isEmpty()){
            throw new RuntimeException("当前栈为空！");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }

    }}
