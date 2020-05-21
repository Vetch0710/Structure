package com.test;

public class SingleLinkStack {

	public static void main(String[] args) {
		Person p1 = new Person(3);
        Person p2 = new Person(1);
        Person p3 = new Person(5);
 
        LinkedListStack stack = new LinkedListStack();
        stack.push(p1);
        stack.push(p2);
        stack.push(p3);
        stack.show();
stack.pop();
stack.show();
	}

}



 class LinkedListStack {
    private Person top = new Person(-1);
    // 判断栈是否为空
    public boolean isEmpty(){
        return top.getNo() == -1;
    }
 
 
    // 入栈
    public void push(Person person){
      
        if(top.getNext() == null){// 第一个节点的插入
            top.setNext(person);
            return;
        }
        Person temp = top.getNext();
        top.setNext(person);
        person.setNext(temp);
    }
 
    // 出栈
    public void pop(){
//        System.out.println("节点为："+top.getNext().getNo());
//        top.setNext(top.getNext().getNext()) ;
    	top=top.getNext();
    }
 
    // 遍历
    public void show(){
        if(top.getNext() == null){
            System.out.println("栈空。。。");
            return;
        }
        Person temp = top;
        while(temp.getNext() != null){
            System.out.println("节点为："+temp.getNext().getNo());
            temp = temp.getNext();
        }
    }
}

 class Person {
    private int no;
    private Person next;
 
    public int getNo() {
        return no;
    }
 
    public void setNo(int no) {
        this.no = no;
    }
 
    public Person getNext() {
        return next;
    }
 
    public void setNext(Person next) {
        this.next = next;
    }
 
    public Person(int no) {
        this.no = no;
    }
 
    @Override
    public String toString() {
        return "Person{" +
                "no=" + no +
                '}';
    }
}