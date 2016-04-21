package jimbob.java.util;

public class LinkedList {
	// ���ڵ�
	private Node root;

	// ��������
	public void add(String data) {
		Node newNode = new Node(data);
		if (this.root == null) {
			this.root = newNode;
		} else {
			this.root.addNode(newNode);
		}
	}

	public void print() {
		if (this.root != null) {
			this.root.print();
		}
	}

}
