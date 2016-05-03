package jimbob.java.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourcesDemo {
	public static void main(String[] args) {
		// Properties还可以用这个类读取和写入
		Locale locale = new Locale("en", "US");
		ResourceBundle rb = ResourceBundle.getBundle("Messages", locale);
		System.out.println(rb.getString("info"));
		System.out.println(MessageFormat.format(rb.getString("welcome"), "jimbob"));

		System.out.println(Locale.getDefault());

	}
}
