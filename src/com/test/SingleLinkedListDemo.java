package com.test;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode node1 = new HeroNode(1, "张", "三");
		HeroNode node2 = new HeroNode(2, "李", "四");
		HeroNode node3 = new HeroNode(3, "王", "五");
		HeroNode node4 = new HeroNode(4, "赵", "六");
		HeroNode node5 = new HeroNode(4, "火狐", "哈哈哈");
		SingleLinkedList singlelist = new SingleLinkedList();
		singlelist.addorder(node1);
		singlelist.addorder(node3);
		singlelist.addorder(node2);
		singlelist.addorder(node4);
		singlelist.showlist();
		System.out.println("");
		singlelist.update(node5);

		singlelist.showlist();
		System.out.println("");
		
		singlelist.delete(1);
		singlelist.delete(2);
		singlelist.delete(3);
		
		singlelist.showlist();
	}

}

class SingleLinkedList {
	// 头节点
	private HeroNode head = new HeroNode(0, "", "");

	// 无序添加
	public void add(HeroNode heronode) {
		// 因为头节点不能动 所以定义一个辅助节点 帮助判断
		HeroNode item = head;

		while (true) {
			// 判断下一个节点是否为空
			if (item.next == null) {
				break;
			}
			item = item.next;
		}
		item.next = heronode;
	}

	// 有序添加
	public void addorder(HeroNode heronode) {

		HeroNode item = head;
		boolean flag = false;
		while (true) {
			if (item.next == null) { // 没有节点 可直接加入
				break;
			} else if (item.next.no > heronode.no) { // 如果该节点的后一个节点的编号大于当前插入节点的编号 ，则将节点插入该节点之后
				break;
			} else if (item.next.no == heronode.no) {// 说明节点已存在
				flag = true;
				break;
			}
			item = item.next;
		}
		if (flag) {
			System.out.println("该节点以存在");
		} else {
			heronode.next = item.next;
			item.next = heronode;
		}

	}

    //删除节点
	public void delete(int no) {
		HeroNode item = head;
		boolean flag = false;
		while (true) {
			if (item.next == null) { // 遍历完成
				break;
			} else if (item.next.no == no) {// 说明节点已存在
				flag = true;
				break;
			}
			item = item.next;
		}
		if (flag) {
			item.next = item.next.next;
		} else {
			System.out.println("没有该节点");
		}
	}

	// 根据no，修改节点信息，
	public void update(HeroNode heronode) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		} else {
			HeroNode item = head.next;
			boolean flag = false;
			while (true) {
				if (item == null) { // 以遍历完成
					break;
				} else if (item.no == heronode.no) {
					flag = true;
					break;
				}
				item = item.next;
			}
			if (flag) {
				item.name = heronode.name;
				item.nickname = heronode.nickname;
			} else {
				System.out.println("没有找到该节点\n");
			}
		}

	}

	// 显示链表
	public void showlist() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		} else {
			HeroNode node = head.next;
			while (true) {
				if (node == null) {
					break;
				} else {
					System.out.println(node);
					node = node.next;
				}
			}
		}
	}

}

//每个节点
class HeroNode {
	public int no;
	public String name, nickname;
	public HeroNode next;

	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}