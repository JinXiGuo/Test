package jimbob.java.util;

public class Test {
	public static void main(String[] args) {
		Linkedlist link = new Linkedlist();
		link.add("Hello");
		link.add("world");
		link.add("你好");
		link.add("世界");
		link.remove("世界");
		Object[] array = link.toArray();
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
