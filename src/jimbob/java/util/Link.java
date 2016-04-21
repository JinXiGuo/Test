package jimbob.java.util;

public class Link {
	// 内部类
	private class Node {
		private String data;
		private Node next;

		public Node(String data) {
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

		public boolean containsNode(String data) {
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

		public String getNode(int index) {
			if (Link.this.foot == index) {
				return this.data;
			} else {
				foot++;
				return this.next.getNode(index);
			}
		}
		
		public void toArrayNode(){
			Link.this.retArray[Link.this.foot] = this.data;
			Link.this.foot++;
			if(this.next!=null){
				this.next.toArrayNode();
			}
		}

		public void setNode(int index, String data) {
			if (Link.this.foot == index) {
				this.data = data;
			} else {
				foot++;
				this.next.setNode(index, data);
			}
		}

		public boolean removeNode(Node previous, String data) {
			if (data.equals(this.data)) {
				previous.next = this.next;
				Link.this.count--;
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
	private String[] retArray;

	// 增加数据
	public boolean add(String data) {
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

	public boolean contains(String data) {

		return this.root.containsNode(data);
	}

	public String get(int index) {
		if (index >= this.count) {
			return null;
		}
		this.foot = 0;
		return this.root.getNode(index);
	}

	// 修改
	public boolean set(int index, String data) {
		if (index > this.count || data == null) {
			return false;
		}
		this.foot = 0;
		this.root.setNode(index, data);
		return true;
	}

	public boolean remove(String data) {
		if (data.equals(this.root.data)) {
			this.root = this.root.next;
			this.count--;
			return true;
		} else {
			return this.root.next.removeNode(this.root, data);
		}

	}

	public String[] toArray() {
		if (this.root == null) {
			return null;
		} else {
			this.foot=0;
			this.retArray = new String[this.count];
			this.root.toArrayNode();
			return this.retArray;
		}
	}

	public static void main(String[] args) {
		Link link = new Link();
		link.add("Hello");
		link.add("world");
		link.add("你好");
		link.add("世界");
		link.remove("世界");
		String[] array= link.toArray();
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
