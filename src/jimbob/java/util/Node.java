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

	// ��һ�ε���(LinkedList)��this=LinkedList.root
	// �ڶ��ε���(Node)��this=LinkedList.root.next
	// �����ε���(Node)��this=LinkedList.root.next.next
	public void addNode(Node newNode) {
		if (this.next == null) {
			this.next = newNode;
		} else {
			// ��ǰ�ڵ�ݹ鱣��
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
