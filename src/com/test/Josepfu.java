package com.test;

public class Josepfu {

	public static void main(String[] args) {
		
		CircleSingleLinkedList list=new CircleSingleLinkedList();
		list.addBoy(5);
//		list.showBoy();
		
		
		list.countBoy(1, 2, 5);
	}

}
class CircleSingleLinkedList{
	private Boy first=null;
	public void addBoy(int nums) {
		if(nums<1) {
			System.out.println("值不对");
			return;
		}
		Boy curBoy=null; ///辅助指针
		for (int i = 1; i <= nums; i++) {
			Boy boy=new Boy(i);
			if(i==1) {
				first=boy;
				first.setNext(first);
				curBoy=first;
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy=boy;
			}
		}
	}
	
	public void showBoy() {
		if(first==null) {
			System.out.println("链表为空");
			return;
		}else {
			Boy curBoy=first;
			while(true) {
				System.out.println("编号为："+curBoy.getNo());
				if(curBoy.getNext()==first) {
					break;
				}
				curBoy=curBoy.getNext();
			}
		}
	}
	
	public void countBoy(int startNo,int countNum,int nums) {
		 if (first==null ||startNo<1||startNo>nums) {
			System.out.println("参数有误");
		}
		 Boy helper=first; //定义辅助节点指向链表的最后一个节点
		 while(true) {
			 if (helper.getNext()==first) {
				 //当前辅助节点指向最后一个节点
				break;
			}
			 helper=helper.getNext();
		 }
		 
		 //报数前，让first和helper分别指向要报数的人和要报数的后一个人
		 for (int i = 0; i < startNo-1; i++) {
			 first=first.getNext();
			 helper=helper.getNext();
		}
		 
		 //开始报数
		 while(true) {
			  if (helper==first) {
				break;
			}
			 //让first和helper移动countNum-1次
				 for (int i = 0; i < countNum-1; i++) {
					 first=first.getNext();
					 helper=helper.getNext();
				}
				 System.out.println(first.getNo()+"号小孩出圈");
				 first=first.getNext();
				 helper.setNext(first);
		 }
		 System.out.println("最后留在圈中的小孩是"+first.getNo());
		 
	}
}
		


class Boy{
	private int no;
	private Boy next;
	public Boy(int no) {
		this.no=no;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Boy getNext() {
		return next;
	}
	public void setNext(Boy next) {
		this.next = next;
	}
	
	
}