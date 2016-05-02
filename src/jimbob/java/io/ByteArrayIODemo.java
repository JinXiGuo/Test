package jimbob.java.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayIODemo {
	public static void main(String[] args) throws Exception {
		String str = "hello* world";
		InputStream in = new ByteArrayInputStream(str.getBytes());
		OutputStream out = new ByteArrayOutputStream();
		int temp;
		while ((temp = in.read()) != -1) {
			out.write(Character.toUpperCase(temp));
		}
		System.out.println(out);
	}
}
