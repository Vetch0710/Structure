package com.test;

public class Queue8 {

	public static void main(String[] args) {
		Queue8 queue8=new Queue8();
		queue8.check(0);
		System.out.printf("一共有%d种解法\n",count);
		System.out.printf("一共判断了%d次冲突：",judgecount);
	}

	
	
	int max=8;
	int []ary=new int[max];
	static int count=0; //一共有多少种解法
	static int judgecount=0; //一共判断了多少次冲突
	
	//输出最终位置
	private void print() {
		count++;
		for (int i = 0; i < ary.length; i++) {
			System.out.print(ary[i]+" ");
		}
		System.out.println();
	}
	
	//判断是否符合规定
	private boolean judge(int n) {
		judgecount++;
		for (int i = 0; i < n; i++) {
			if (ary[i]==ary[n] ||Math.abs(n-i)==Math.abs(ary[n]-ary[i])) {
				//ary[i]==ary[n] : 判断是否在同一列
				//Math.abs(n-i)==Math.abs(ary[n]-ary[i])  ：判断是否在一条斜线上（两点的相差行等于相差列）
				return false;
			}
		}
		return true; 
	}
	
	
	//放置第 n个皇后
	private void check(int n) {
		if (n==max) {
			print();
			return ;
		}else {
			for (int i = 0; i < max; i++) {
				ary[n]=i; //先将棋子放入某一列上
				if (judge(n)) { //判断是否符合规定
					check(n+1);
				}
			}
		}
	}
	
	
}
