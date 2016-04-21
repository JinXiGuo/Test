package jimbob.java.base;


public class Test {
	public static void main(String[] args) {
		Person s=new Person();
	}
	
}

class Person{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

class Student extends Person{
	private String id;

	Student(){}
	Student(String s){
		
	}
	
	public void setName(String name) {
		super.setName(name);
		System.out.println(name);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
