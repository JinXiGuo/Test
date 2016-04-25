package jimbob.java.petshop;

import jimbob.java.util.Linkedlist;

public class TestDemo {
	public static void main(String[] args) {
		PetShop petShop = new PetShop();
		petShop.add(new Dog("d1", 10));
		petShop.add(new Dog("d2", 10));
		petShop.add(new Cat("c1", 10));
		petShop.add(new Cat("c2", 10));
		petShop.add(new Cat("c3", 10));
		petShop.add(new Cat("c4", 10));

		petShop.remove(new Cat("c4", 10));

		Linkedlist pets = petShop.search("c");

		Object[] all = pets.toArray();

		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}

	}
}
