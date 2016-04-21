package jimbob.java.util;

public class LinkedList {
	// 根节点
	private Node root;

	// 增加数据
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
