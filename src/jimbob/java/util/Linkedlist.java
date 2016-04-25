package jimbob.java.util;

public class Linkedlist {
	// 内部类
	private class Node {
		private Object data;
		private Node next;

		public Node(Object data) {
			this.data = data;
		}

		public void addNode(Node newNode) {
			if (this.next == null) {
				this.next = newNode;
			} else {
				// 当前节点递归保存
				this.next.addNode(newNode);
			}
		}

		public boolean containsNode(Object data) {
			if (data == null) {
				return false;
			} else if (data.equals(this.data)) {
				return true;
			} else if (this.next != null) {
				return this.next.containsNode(data);
			} else {
				return false;
			}
		}

		public Object getNode(int index) {
			if (Linkedlist.this.foot == index) {
				return this.data;
			} else {
				foot++;
				return this.next.getNode(index);
			}
		}

		public void toArrayNode() {
			Linkedlist.this.retArray[Linkedlist.this.foot] = this.data;
			Linkedlist.this.foot++;
			if (this.next != null) {
				this.next.toArrayNode();
			}
		}

		public void setNode(int index, Object data) {
			if (Linkedlist.this.foot == index) {
				this.data = data;
			} else {
				foot++;
				this.next.setNode(index, data);
			}
		}

		public boolean removeNode(Node previous, Object data) {
			if (data.equals(this.data)) {
				previous.next = this.next;
				Linkedlist.this.count--;
			} else {
				this.next.removeNode(this, data);
				return false;
			}
			return true;
		}
	}

	private Node root;
	private int count = 0;
	private int foot;
	private Object[] retArray;

	// 增加数据
	public boolean add(Object data) {
		if (data != null) {
			Node newNode = new Node(data);
			if (this.root == null) {
				this.root = newNode;
			} else {
				this.root.addNode(newNode);
			}
			count++;
			return true;
		} else {
			return false;
		}

	}

	public boolean isEmpty() {
		return this.count == 0;
	}

	public int size() {
		return this.count;
	}

	public boolean contains(Object data) {

		return this.root.containsNode(data);
	}

	public Object get(int index) {
		if (index >= this.count) {
			return null;
		}
		this.foot = 0;
		return this.root.getNode(index);
	}

	// 修改
	public boolean set(int index, Object data) {
		if (index > this.count || data == null) {
			return false;
		}
		this.foot = 0;
		this.root.setNode(index, data);
		return true;
	}

	public boolean remove(Object data) {
		if (data.equals(this.root.data)) {
			if (root.next != null) {
				this.root = this.root.next;
				this.count--;
			} else {
				this.root = null;
				this.count = 0;
			}
			return true;
		} else {
			if (this.root.next != null)
				return this.root.next.removeNode(this.root, data);
			else
				return false;
		}
	}

	public Object[] toArray() {
		if (this.root == null) {
			return null;
		} else {
			this.foot = 0;
			this.retArray = new Object[this.count];
			this.root.toArrayNode();
			return this.retArray;
		}
	}

}
