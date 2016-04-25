package jimbob.java.petshop;

public class Cat implements Pet {
	private String name;
	private int age;

	Cat(String name, int age) {
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
		return "Cat [name=" + name + ", age=" + age + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return true;
		}
		if (!(obj instanceof Cat)) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Cat cat = (Cat) obj;
		if (this.name.equals(cat.name) && this.age == cat.age) {
			return true;
		}
		return false;
	}
}
