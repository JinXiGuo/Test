package jimbob.java.io;

import java.io.File;
import java.io.PrintStream;

public class PrintStreamDemo {
	public static void main(String[] args) throws Exception{
		PrintStream ps=new PrintStream(new File("D:/workspace/java/Test/Buffered.txt"));
		ps.println("hello world");
		ps.println(true);
		ps.printf("hello %s","jimbob");
		ps.close();
		System.err.println("dd");
	}
}
