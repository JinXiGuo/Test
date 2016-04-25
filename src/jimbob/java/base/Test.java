package jimbob.java.base;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Test {
	public static void main(String[] args) {
		StringWriter out = new StringWriter();
		try {
			double t = 2 / 0;
		}catch(Exception e){
			e.printStackTrace(new PrintWriter(out));
			System.out.println(out);
		}
		finally{
			
		}
		
		System.out.println("11");
	}
}