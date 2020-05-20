package com.array;

import java.util.Scanner;

public class ArrayQueue {
    public static void main(String[] args) {

        System.out.println("数组模拟环形队列案例！！");

        //创建一个环形队列
        CircleArray queue = new CircleArray(4);//设置为4，队列中最大有效数据是3
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列头的数据");
            System.out.println("i(size):查看队列的有效元素");

            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':

                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());

                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的元素是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'i':
                	int res = queue.size();
                	 System.out.printf("队列的有效元素是%d\n", res);
                	break;

                default:
                    break;

            }

        }
        System.out.println("程序退出");

    }
}

class CircleArray {
    private int maxSize;//表示数组的最大容量。

    //front 变量的含义做一个调整：front 就指向队列的第一元素，也就是说 arr[front]
    //front 的初始值=0
    private int front;//队列头

    //rear 变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置。因为希望空出
    //一个空间做为约定  rear 的初始值=0
    private int rear;//队列尾

    private int[] arr;//该数组用于存放数据，模拟队列。

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据~~");
            return;
        }

        //直接将数据加入
        arr[rear] = n;
        //将rear后移    这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        //front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据！！！");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素
        //
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求当前队列的有效个数
    public int size() {

        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的没有数据~~~");
        }
        return arr[front];
    }
}
