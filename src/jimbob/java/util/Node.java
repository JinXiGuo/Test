package jimbob.java.util;

public class Node {
	private String date;
	private Node next;

	public Node(String date) {
		this.date = date;
	}

	public String getData() {
		return this.date;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext() {
		return this.next;
	}

	// 第一次调用(LinkedList)：this=LinkedList.root
	// 第二次调用(Node)：this=LinkedList.root.next
	// 第三次调用(Node)：this=LinkedList.root.next.next
	public void addNode(Node newNode) {
		if (this.next == null) {
			this.next = newNode;
		} else {
			// 当前节点递归保存
			this.next.addNode(newNode);
		}
	}

	public void print() {
		System.out.println(this.date);
		if (this.next != null) {
			this.next.print();
		}
	}

}
