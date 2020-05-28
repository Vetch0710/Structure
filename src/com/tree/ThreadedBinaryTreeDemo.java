package com.tree;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		HeroNode root = new HeroNode(1,"qq");
		HeroNode node2 = new HeroNode(3,"qq");
		HeroNode node3 = new HeroNode(6,"qq");
		HeroNode node4 = new HeroNode(8,"qq");
		HeroNode node5 = new HeroNode(10,"qq");
		HeroNode node6 = new HeroNode(14,"qq");
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		
		
		BinaryTree3 tree=new BinaryTree3();
		tree.setRoot(root);
		tree.ThreadedTree();
//		System.out.println(node3.getLeft());
//		System.out.println(node3.getRight());
		tree.midList();
		
		
		
	}

}


class BinaryTree3 {
	private HeroNode root;

	private HeroNode pre;
	public HeroNode getRoot() {
		return root;
	}

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	public void ThreadedTree() {
		this.ThreadedTree(root);
	}
	public void ThreadedTree(HeroNode node) {
		//按照中序遍历的顺序
		if (node==null) {
			return;
		}
		//左遍历
		ThreadedTree(node.getLeft());
		//处理当前结点
		  //前驱节点
		 if (node.getLeft()==null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		//后继节点
		if (pre!=null && pre.getRight()==null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		//设置pre节点
		pre=node;
		
		//右遍历
		ThreadedTree(node.getRight());
		
	}

	


	// 遍历线索二叉树  中序
	public void midList() {
		HeroNode node=root;
		while (node!=null) {
			while (node.getLeftType()==0) {
				node=node.getLeft();
			}
			
			System.out.println(node);
			
			while(node.getRightType()==1) {
				node=node.getRight();
				System.out.println(node);
			}
			
			node=node.getRight();
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
	
	
	

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

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