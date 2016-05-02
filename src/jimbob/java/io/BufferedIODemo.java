package jimbob.java.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedIODemo {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println(str);
	}
}
