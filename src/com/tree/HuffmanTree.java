package com.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {
		System.out.println((byte)Integer.parseInt("00011100", 2));
		int a=28;
		System.out.println(Integer.toBinaryString(a));
		
//		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
//		pre(createHuffmanTree(arr));
		
	}
	
	//前序遍历
	public static void pre(HuffmanNode node) {
		if (node!=null) {
			node.pre();
		}else {
			System.out.println("空");
		}
	}
	
//创建哈夫曼树
	public static HuffmanNode createHuffmanTree(int[] arr) {
		List<HuffmanNode> nodes = new ArrayList<HuffmanNode>();
		for (int i : arr) {
			// 讲数组中的每个值转换成一个结点
			nodes.add(new HuffmanNode(i));
		}

		while (nodes.size() > 1) {
			// 从小到大排序
			Collections.sort(nodes);
			// 取出权值最小和次小的二叉树（就是一个结点）
			HuffmanNode left = nodes.get(0);
			HuffmanNode right = nodes.get(1);
			// 将两个结点构造出新的二叉树
			HuffmanNode parent = new HuffmanNode(left.value + right.value);
			parent.left = left;
			parent.right = right;

			// 删除这两个结点
			nodes.remove(left);
			nodes.remove(right);

			// 将新的结点加入node中
			nodes.add(parent);
		}
		return nodes.get(0);
	}

}

//Comparable接口可使结点对象持续排序
class HuffmanNode implements Comparable<HuffmanNode> {
	int value;
	HuffmanNode left;
	HuffmanNode right;

	public HuffmanNode(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "HuffmanNode [value=" + value + "]";
	}

	@Override
	public int compareTo(HuffmanNode o) {
		// 表示从小到大排序
		return this.value - o.value;
	}
	
	//前序遍历
	public void pre() {
		System.out.println(this);
		if (this.left!=null) {
			this.left.pre();
		}
		if (this.right!=null) {
			this.right.pre();
		}
	}

}