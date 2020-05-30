package com.Algorithm;

public class Hanoitower {

	public static void main(String[] args) {
		//分治算法解决汉诺塔问题
		hanoiTower(3,'A','B','C');
	}
	
	public static void hanoiTower(int num,char a,char b,char c) {
		if (num==1) {
			System.out.println("第1个盘从"+a+"->"+c);
		}else {
			//有多个盘的情况时,将其分为两个部分，上面部分和最下面的一个盘，
			//将上面的部分移动到A->B
			hanoiTower(num-1,a,c,b);
			//，将最下面的一个盘A->C
			System.out.println("第"+num+"个盘从"+a+"->"+c);
			//将B的部分移动到C   
			hanoiTower(num-1,b,a,c);
		}
	}

}
