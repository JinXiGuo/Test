package jimbob.java.special;


public class CloneDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		Book book1 = new Book("b1","p1");
		Book book2 = (Book)book1.clone();
		System.out.println(book1.toString());
		System.out.println(book2.toString());
		System.out.println(book1==book2);
	}
}

class Book implements Cloneable {
	private String title;
	private String price;

	public Book(String title, String price) {
		this.price = price;
		this.title = title;
	}


	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
