package jimbob.java.reflect;

import java.util.Date;

public class ClassDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		//1.
		Date data=new Date();
		Class<?> cls=data.getClass();
		System.out.println(cls);
		//2.
		Class<?> cls2=Date.class;
		System.out.println(cls2);
		//3.
		Class<?> cls3=Class.forName("java.util.Date");
		System.out.println(cls3);
	}
}
