package com.tree;

public class BinaryTreeFindDemo2 {

	private static Node2 root;
	private static Node2 node2;
	private static Node2 node3;
	private static Node2 node4;
	private static Node2 node5;
	private static Node2 node6;
	private static Node2 node7;

	public static void main(String[] args) {
		BinaryTree2 tree = new BinaryTree2();
		root = new Node2(1, "qq");
		node2 = new Node2(2, "ww");
		node3 = new Node2(3, "ee");
		node4 = new Node2(4, "rr");
		node5 = new Node2(5, "rr");
		node6 = new Node2(6, "rr");
		node7 = new Node2(7, "rr");
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		node3.setRight(node7);
		
		tree.setRoot(root);
		System.out.println("前序查找");
		Node2 n=tree.preSearch(1);
		if (n==null) {
			System.out.println("没有该节点");
		}else {
			System.out.println(n.toString());
		}
		
		
		
		System.out.println("中序查找");
		Node2 n1=tree.midSearch(1);
		if (n1==null) {
			System.out.println("没有该节点");
		}else {
			n1.toString();
		}
		
		
		
		System.out.println("后序查找");
		Node2 n2=tree.postSearch(1);
		if (n2==null) {
			System.out.println("没有该节点");
		}else {
			n2.toString();
		}
	}

}

class BinaryTree2 {
	private Node2 root;

	public Node2 getRoot() {
		return root;
	}

	public void setRoot(Node2 root) {
		this.root = root;
	}

	// 前序遍历
	public Node2 preSearch(int no) {

		if (this.root != null) {
			return this.root.preSearch(no);
		} else {
			return null;
		}
	}

	// 中序遍历
	public Node2 midSearch(int no) {
		if (this.root != null) {
			return this.root.midSearch(no);
		} else {
			return null;
		}
	}

	// 后序遍历
	public Node2 postSearch(int no) {
		if (this.root != null) {
			return this.root.postSearch(no);
		} else {
			return null;
		}
	}
}

class Node2 {
	private int no;
	private String name;
	private Node2 left;
	private Node2 right;

	public Node2(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node2 getLeft() {
		return left;
	}

	public void setLeft(Node2 left) {
		this.left = left;
	}

	public Node2 getRight() {
		return right;
	}

	public void setRight(Node2 right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}

	// 前序遍历
	public Node2 preSearch(int no) {
		System.out.println(this.no+"-----");
		if (this.no == no) {
			return this;
		}
		Node2 temp = null;
		if (this.left != null) { // 左遍历
			temp = this.left.preSearch(no);
		}
		if (temp != null) {
			return temp;
		}
		if (this.right != null) { // 右遍历
			temp = this.right.preSearch(no);
		}
		return temp;
	}

	// 中序遍历
	public Node2 midSearch(int no) {
		
		Node2 temp = null;
		if (this.left != null) { // 左遍历
			temp = this.left.midSearch(no);
		}
		if (temp != null) {
			return temp;
		}
		System.out.println(this.no+"-----");
		if (this.no == no) { // 父节点
			return this;
		}

		if (this.right != null) { // 右遍历
			temp = this.right.midSearch(no);
		}
		return temp;
	}

	// 后序遍历
	public Node2 postSearch(int no) {
		
		Node2 temp = null;
		if (this.left != null) { // 左遍历
			temp = this.left.postSearch(no);
		}
		if (temp != null) {
			return temp;
		}

		if (this.right != null) { // 右遍历
			temp = this.right.postSearch(no);
		}
		if (temp != null) {
			return temp;
		}
		System.out.println(this.no+"-----");
		if (this.no == no) { // 父节点
			return this;
		}
		return temp;
	}

}
