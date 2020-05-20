package com.array;

public class SparseArray {

	public static void main(String[] args) {
		//创建原始数组11*11
		//0表示没有棋子，1表示黑子  2表示蓝子
		int startArr1[][]=new int [11][11];
		startArr1[1][2]=1;
		startArr1[2][3]=2;
		startArr1[3][5]=2;
		System.out.println("原始数组：");
		for(int[] row:startArr1) {
			for(int data :row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		//判断原先数组有几行几列，几个不同数值
		int sum=0;
		for (int i = 0; i < startArr1.length; i++) {
			for (int j = 0; j < startArr1[0].length; j++) {
				if(startArr1[i][j]!=0) {
					sum++;
				}
			}
		}
		//创建稀疏数组
		int sparseArray[][]=new int [sum+1][3];
		sparseArray[0][0]=startArr1.length;
		sparseArray[0][1]=startArr1[0].length;
		sparseArray[0][2]=sum;
		
		//将原先数组中的值记录到稀疏数组中
		int sparseArrayrow=1;
		for (int i = 0; i < startArr1.length; i++) {
			for (int j = 0; j < startArr1[0].length; j++) {
				if(startArr1[i][j]!=0) {
					sparseArray[sparseArrayrow][0]=i;
					sparseArray[sparseArrayrow][1]=j;
					sparseArray[sparseArrayrow][2]=startArr1[i][j];
					sparseArrayrow++;
				}
			}
		}
		
	System.out.println("稀疏数组：   ");
	for(int[] row:sparseArray) {
		for(int data :row) {
			System.out.printf("%d\t",data);
		}
		System.out.println();
	}
		
	//将稀疏数组转为二维数组：
	int  changeArray[][]=new int[sparseArray[0][0]][sparseArray[0][1]];
	for (int i = 1; i < sparseArray.length; i++) {
			changeArray[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
	}
	
	 
	//转化后的二维数组
	System.out.println("稀疏数组还原后的数组：");
	for(int[] row:changeArray) {
		for(int data :row) {
			System.out.printf("%d\t",data);
		}
		System.out.println();
	}
	}
}
