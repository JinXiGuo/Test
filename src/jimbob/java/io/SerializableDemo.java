package jimbob.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
class Book implements Serializable {
	//transient 该字段不可以序列化
	private transient String title;
	private double price;

	public Book(String title, Double price) {
		this.title = title;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}
}

public class SerializableDemo{
	public static void main(String[] args) throws Exception {
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File("Buffered.txt")));
		out.writeObject(new Book("java",200.0));
		out.close();
		
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File("Buffered.txt")));
		Object obj= in.readObject();
		System.out.println(obj);
		in.close();
	}
}
