package jimbob.java.petshop;

public class Dog implements Pet {
	private String name;
	private int age;

	Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getAge() {
		return this.age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return true;
		}
		if (!(obj instanceof Dog)) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Dog dog = (Dog) obj;
		if (this.name.equals(dog.name) && this.age == dog.age) {
			return true;
		}
		return false;
	}

}
