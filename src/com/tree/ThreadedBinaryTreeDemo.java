package com.tree;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class BinaryTree3 {
	private HeroNode root;

	public HeroNode getRoot() {
		return root;
	}

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	

	// 前序遍历
	public HeroNode preSearch(int no) {

		if (this.root != null) {
			return this.root.preSearch(no);
		} else {
			return null;
		}
	}

	// 中序遍历
	public HeroNode midSearch(int no) {
		if (this.root != null) {
			return this.root.midSearch(no);
		} else {
			return null;
		}
	}

	// 后序遍历
	public HeroNode postSearch(int no) {
		if (this.root != null) {
			return this.root.postSearch(no);
		} else {
			return null;
		}
	}
}









class HeroNode {
	private int no;
	private String name;
	private HeroNode left; //左节点
	private HeroNode right; //右节点
	
	private int leftType; // leftType==0 表示指像左子树  ，1代表指向前驱节点
	private int rightType; //rightType==0 表示指像右子树  ，1代表指向后继节点
	
	
	

	public HeroNode(int no, String name) {
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

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}

	// 前序遍历
	public HeroNode preSearch(int no) {
		System.out.println(this.no+"-----");
		if (this.no == no) {
			return this;
		}
		HeroNode temp = null;
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
	public HeroNode midSearch(int no) {
		
		HeroNode temp = null;
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
	public HeroNode postSearch(int no) {
		
		HeroNode temp = null;
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