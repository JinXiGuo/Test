package jimbob.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {
	public static void main(String[] args) throws Exception {
		String fileName="title";
		Class<?> cls=Class.forName("jimbob.java.reflect.Book");
		//�õ����й��췽��	cls.getConstructors();
		Constructor<?> constructor=cls.getConstructor(String.class,double.class);
		Object obj= constructor.newInstance("hello",20);
		System.out.println(obj.toString());
		
		//ͨ��������÷���
		Method setMet=cls.getMethod("set"+initcap(fileName), String.class);
		Method getMet=cls.getMethod("get"+initcap(fileName));
		setMet.invoke(obj, "java����");
		System.out.println(getMet.invoke(obj));
		
		//ͨ���������˽������
		Field field=cls.getDeclaredField("title");
		field.setAccessible(true);
		field.set(obj, "javaBase");
		System.out.println(field.get(obj));
	}
	
	public static String initcap(String str){
		return str.substring(0,1).toUpperCase()+str.substring(1);
	}
}
