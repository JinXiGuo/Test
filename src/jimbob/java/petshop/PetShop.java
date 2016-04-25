package jimbob.java.petshop;

import jimbob.java.util.Linkedlist;

public class PetShop {
	private Linkedlist pets = new Linkedlist();

	public void add(Pet pet) {
		this.pets.add(pet);
	}

	public void remove(Pet pet) {
		this.pets.remove(pet);
	}

	// Ä£ºı²éÑ¯
	public Linkedlist search(String keyword) {
		Linkedlist result = new Linkedlist();
		Object[] pets = this.pets.toArray();
		for (int i = 0; i < pets.length; i++) {
			Pet pet = (Pet) pets[i];
			if (pet.getName().contains(keyword))
				result.add(pet);
		}

		return result;
	}

}
