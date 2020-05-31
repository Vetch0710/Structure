package com.Algorithm;

import java.util.Arrays;

public class Prim {

	public static void main(String[] args) {
		// 普里姆算法：

		char[] data = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int verxs = data.length;
		int[][] weight = new int[][] { { 10000, 5, 7, 10000, 10000, 10000, 2 },
				{ 5, 100000, 100000, 9, 10000, 10000, 3 }, { 7, 10000, 10000, 10000, 8, 10000, 10000 },
				{ 10000, 9, 10000, 10000, 10000, 4, 10000 }, { 10000, 10000, 8, 10000, 10000, 5, 4 },
				{ 10000, 10000, 10000, 4, 5, 10000, 6 }, { 2, 3, 10000, 10000, 4, 6, 10000 }, };
		MGraph GM = new MGraph(verxs);
		MinTree tree = new MinTree();
		tree.createGraph(GM, verxs, data, weight);
		tree.show(GM);
		tree.prim(GM,1);
	}

}

class MinTree {
	public void createGraph(MGraph g, int verxs, char[] data, int[][] weight) {
		int i, j;
		for (i = 0; i < verxs; i++) {
			g.data[i] = data[i];
			for (j = 0; j < verxs; j++) {
				g.weight[i][j] = weight[i][j];
			}
		}
	}

	public void show(MGraph g) {
		for (int[] link : g.weight) {
			System.out.println(Arrays.toString(link));
		}
	}

	// Prim算法 g:图 v:顶点
	public void prim(MGraph g, int v) {
		int visited[] = new int[g.verxs];
		int sum=0; //记录总权值
		visited[v] = 1; // 把当前结点标记为以访问
		int h1 = -1; // 记录两个顶点的下标
		int h2 = -1;
		int minWeight = 10000;
		for (int i = 1; i < g.verxs; i++) { //表示第几条边      一共有顶点-1 条边
			for (int j = 0; j < g.verxs; j++) {// 表示遍历已经访问过的结点
				for (int k = 0; k < visited.length; k++) { // 遍历没有访问过的结点
					if (visited[j] == 1 && visited[k] == 0 && g.weight[j][k] < minWeight) {  //比较权值
						minWeight = g.weight[j][k];
						h1 = j; //记录边的 起点
						h2 = k;  //记录边的终点
					}
				}
			}
			System.out.println(g.data[h1]+"->"+g.data[h2]+" "+g.weight[h1][h2]);
			sum+=g.weight[h1][h2]; //计算总权值
			visited[h2] = 1;  //将边的终点 设为以访问
			minWeight=10000; 
		}	
		System.out.println("总权值为"+sum);
	}

}

class MGraph {
	int verxs; // 图的节点数
	char[] data; // 存放节点数据
	int[][] weight; // 存放边

	public MGraph(int verxs) {
		this.verxs = verxs;
		data = new char[verxs];
		weight = new int[verxs][verxs];
	}
}
