package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
	private ArrayList<String> vertexList;// 存储顶点集合
	private int[][] edges; // 存储图对应的邻接矩阵
	private int numOfEdges; // 表示边的数目
   private boolean[] isVisited;
	public static void main(String[] args) {

		
		String v1[]= {"A","B","C","D","F","G","Z"};
		int n=v1.length;
		Graph g=new Graph(n);
		for(String value:v1) {
			g.insertV(value);
		}
		g.insertE(0, 2, 1);
		g.insertE(0, 3, 1);
		g.insertE(0, 5, 1);
		g.insertE(2, 3, 1);
		g.insertE(2, 4, 1);
		g.insertE(2, 6, 1);
		g.insertE(3, 1, 1);
		
		g.show();
		
//		System.out.println("深度优先");
//		g.dfs();
		System.out.println("广度优先");
		g.bfs();
	}

	// n 顶点数
	public Graph(int n) {
		this.edges = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
		isVisited=new boolean[n];
	}

	//得到第一个邻接结点的下标 w
	public int getFirstNei(int index) {
		for (int i = 0; i < vertexList.size(); i++) {
			if (edges[index][i]>0) {
				return i;
			}
		}
		return -1;
	}
	
	//根据前一个邻接结点的下标来获取下一个邻接结点
	public int getNextNei(int v1,int v2) {
		for (int i = v2+1; i < vertexList.size(); i++) {
			if (edges[v1][i]>0) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	
	//深度优先遍历
	public void dfs(boolean[] isVi,int i) {
		System.out.print(getValue(i)+"->");
		isVi[i]=true;
//		System.out.println(i+Arrays.toString(isVisited));
		int w=getFirstNei(i);
		while(w!=-1) {
			if (!isVi[w]) {
				//没有被访问过
				dfs(isVi,w);
			}
			w=getNextNei(i,w);
		}
	}
	
	public void dfs() {
		for (int i = 0; i < getNumV(); i++) {
			if (!isVisited[i]) {
				dfs(isVisited,i);
			}
			
		}
	}
	//广度优先
	public void bfs(boolean[] isVi,int i) {
		int u;//表示队列的头节点对应的下标
		int w;//邻接结点
		LinkedList queue=new LinkedList();
		System.out.print(getValue(i)+"->");
		isVi[i]=true;	
		queue.addLast(i);
		while(!queue.isEmpty()) {
			u=(Integer)queue.removeFirst();
			w=getFirstNei(u);
			while(w!=-1) {
				if (!isVi[w]) {
					System.out.print(getValue(w)+"->");
					isVi[w]=true;	
					queue.addLast(w);
				}
				w=getNextNei(u, w);
			}
		}
	}
	
	
	//广度优先
	public void bfs() {
		for (int i = 0; i < getNumV(); i++) {
			if (!isVisited[i]) {
				bfs(isVisited,i);
			}
			
		}
	}
	
	
	
	
	
	
	public int getNumV() {
		return vertexList.size();
	}

	public int getEdge() {
		return numOfEdges;
	}

	// 返回结点 对应的数据
	public String getValue(int i) {
		return vertexList.get(i);
	}

	// 返回权值
	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	// 显示矩阵
	public void show() {
		for (int[] link : edges) {
			System.out.println(Arrays.toString(link));
		}
	}

	// 插入结点
	public void insertV(String vertex) {
		vertexList.add(vertex);
	}

	/**
	 * 
	 * @param v1     矩阵中第几个顶点的下标
	 * @param v2     矩阵中第几个顶点的下标
	 * @param weight 0/1
	 */
	public void insertE(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}

}
