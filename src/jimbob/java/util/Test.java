package jimbob.java.util;

public class Test {
	public static void main(String[] args) {
		Linkedlist link = new Linkedlist();
		link.add("Hello");
		link.add("world");
		link.add("���");
		link.add("����");
		link.remove("����");
		Object[] array = link.toArray();
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
