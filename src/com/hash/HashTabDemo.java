package com.hash;

import java.util.Scanner;

public class HashTabDemo {

	public static void main(String[] args) {
		HashTab hash = new HashTab(7);
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("add");
			System.out.println("list");
			System.out.println("find");
			System.out.println("exit");

			key = scanner.next();
			switch (key) {
			case "add":
				System.out.println("id:");
				int id = scanner.nextInt();
				System.out.println("name:");
				String name = scanner.next();
				Emp emp = new Emp(id, name);
				hash.add(emp);
				break;
			case "find":
				System.out.println("id:");
				int fid = scanner.nextInt();
				hash.findel(fid);
				break;
			case "list":
				hash.list();
				break;
			case "exit":
				scanner.close();
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}

}

//每一个节点
class Emp {
	public int id;
	public String name;
	public Emp next;

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}

//由节点组成的单链表
class EmpLinkedList {
	private Emp head;

	public void add(Emp emp) {
		if (head == null) {
			head = emp;
			return;
		}

		Emp temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = emp;
	}

	public void list(int no) {
		if (head == null) {
			System.out.println("第" + (no + 1) + "条链表为空");
			return;
		}
		Emp temp = head;
		while (true) {
			System.out.print(temp.id + "---" + temp.name);
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
	}

	// 查找
	public Emp find(int id) {
		if (head == null) {
			System.out.println("链表为空");
			return null;
		}
		Emp temp = head;
		while (true) {
			if (temp.id == id) {
				break;
			}
			if (temp.next == null) {
				temp = null;
				break;
			}
			temp = temp.next;
		}
		return temp;
	}

}

//HashTab  管理多条链表
class HashTab {
	private EmpLinkedList[] emplinkArray;
	private int size;

	public HashTab(int size) {
		this.size = size;
		emplinkArray = new EmpLinkedList[size];
		for (int i = 0; i < size; i++) {
			emplinkArray[i] = new EmpLinkedList();
		}
	}

	// 添加新元素
	public void add(Emp emp) {
		int linkindex = HashFun(emp.id);
		emplinkArray[linkindex].add(emp);
	}

	// 创建一个简单的散列函数（将元素散列开），使用取模法
	public int HashFun(int id) {
		return id % size;
	}

	// 遍历
	public void list() {
		for (int i = 0; i < size; i++) {
			emplinkArray[i].list(i);
		}
	}

	public void findel(int id) {
		int index = HashFun(id);
		Emp aa = emplinkArray[index].find(id);
		if (aa == null) {
			System.out.println("未找到");
		} else {
			System.out.println("id:" + aa.id + "name:" + aa.name);
		}
	}

}
