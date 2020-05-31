package com.Algorithm;

public class KnapsackProblem {
//动态规划法  解决背包问题
	public static void main(String[] args) {
		String name[]= {"吉他","电视","冰箱"};
		int[] w = { 1, 4, 3 }; // 物品的重量
		int[] val = { 1500, 3000, 2000 };// 物品的价值
		int m = 4; // 背包的容量
		int n = val.length; // 物品的个数
		//记录背包价值
		int[][] list=new int[n+1][m+1];
		//记录背包物品
		String all[][]=new String[name.length+1][m+1];
		//将第一行和第一列设为0
		for (int i = 0; i < list.length; i++) {
			list[i][0]=0;
			all[i][0]="";
			
		}
		for (int j = 0; j < list[0].length; j++) {
			list[0][j]=0;
			all[0][j]="";
		}
		
		//动态规划处理
		for (int i = 1; i < list.length; i++) {
			for (int j = 1; j < list[0].length; j++) {
				if (w[i-1]>j) {
					//如果物品重量大于 背包容量则    背包物品   等于  上一层的背包物品
					list[i][j]=list[i-1][j];
					all[i][j]=all[i-1][j];
				}else {
					//list[i-1][j]:上一层的最优解 的价值
					//val[i-1]: 新添加商品的价值       list[i-1][j-w[i-1]]:上一层的剩余背包容量最优解（j-w[i-1]]: 表示剩余容量=背包容量-新添加的商品重量）
					//list[i][j]=Math.max(list[i-1][j], val[i-1]+list[i-1][j-w[i-1]]);
					if (list[i-1][j]>(val[i-1]+list[i-1][j-w[i-1]])) {
						list[i][j]=list[i-1][j];
						
					}else {
						list[i][j]=val[i-1]+list[i-1][j-w[i-1]];
						all[i][j]=name[i-1]+" "+all[i-1][j-w[i-1]];
					}
					
				}
			}
		}
		
		
		

		
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[0].length; j++) {
				System.out.print(list[i][j]+" ");
			}
			System.out.println();
		}
//		for (int i = 0; i < all.length; i++) {
//			for (int j = 0; j < all[0].length; j++) {
//				System.out.print(all[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println("背包中的物品有:"+all[all.length-1][all[0].length-1]);
		
		
	}

}
