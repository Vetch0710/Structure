package com.tree;

public class BinaryTreeListDemo {

	private static Node root;
	private static Node node2;
	private static Node node3;
	private static Node node4;
	private static Node node5;
	private static Node node6;
	private static Node node7;
	private static Node node8;

	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		root = new Node(1,"qq");
		node2 = new Node(2,"ww");
		node3 = new Node(3,"ee");
		node4 = new Node(4,"rr");
		node5 = new Node(5,"rr");
		node6 = new Node(6,"rr");
		node7= new Node(7,"rr");
		node8 = new Node(8,"rr");
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		node3.setRight(node7);
		tree.setRoot(root);
		System.out.println("前序遍历");
		tree.preOrder();
		System.out.println("中序遍历");
		tree.midOrder();
		System.out.println("后序遍历");
		tree.postOrder();
	}

}

class BinaryTree{
	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	//前序遍历
	public void preOrder() {
		if (this.root!=null) {
			this.root.preOder();
		}else {
			System.out.println("二叉树为空");
		}
	}
	//中序遍历
	public void midOrder() {
		if (this.root!=null) {
			this.root.midOder();
		}else {
			System.out.println("二叉树为空");
		}
	}
	//后序遍历
	public void postOrder() {
		if (this.root!=null) {
			this.root.postOder();
		}else {
			System.out.println("二叉树为空");
		}
	}
}














class  Node{
	private int no;
	private String name;
	private  Node left;
	private  Node right;
	
	public Node(int no,String name) {
		this.no=no;
		this.name=name;
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

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}
	
	//前序遍历
	public void preOder() {
		System.out.println(this); //父节点
		if (this.left!=null) { //左遍历
			this.left.preOder();
		}
		if (this.right!=null) { //右遍历
			this.right.preOder();
		}
	}
	//中序遍历
	public void midOder() {
		
		if (this.left!=null) { //左遍历
			this.left.midOder();
		}
		System.out.println(this); //父节点
		if (this.right!=null) { //右遍历
			this.right.midOder();
		}
	}
	//后序遍历
	public void postOder() {
		
		if (this.left!=null) { //左遍历
			this.left.postOder();
		}
		
		if (this.right!=null) { //右遍历
			this.right.postOder();
		}
		System.out.println(this); //父节点
	}
	
	
	
	
	
	
}
