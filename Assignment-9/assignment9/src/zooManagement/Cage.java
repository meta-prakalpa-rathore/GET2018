package zooManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents cages in the Zoo
 * @author Prakalpa-Rathore
 */
public class Cage {

	private AnimalName animalType; //specifies the type of animal cage can hold, eg lion, parrot etc
	private int capacity;
	List<Animal> listOfAnimals = new ArrayList<>();
			
	public Cage(AnimalName animalType, int capacity) {
		this.animalType = animalType;
		this.capacity = capacity;
	}
	
	public AnimalName getAnimalType() {
		return animalType;
	}

	public void setAnimalType(AnimalName animalType) {
		this.animalType = animalType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Animal> getListOfAnimals() {
		return listOfAnimals;
	}
	
	public void addAnimal(Animal animal) {
			listOfAnimals.add(animal);
	}
	
	
	/**
	 * this method is used to remove an animal from the cage
	 * @return true if animal is removed, false otherwise
	 */
	public boolean removeAnimal() {
		
		boolean removed = false;
		
		if(listOfAnimals.size() > 0)
		{
			listOfAnimals.remove(0);
			removed = true;
		}
		
		return removed;
	}
	
	
	/**
	 * this methods calculates the available capacity of the cage
	 * @return the spare capacity
	 */
	public int spareCapacity() {
		return capacity - listOfAnimals.size();
	}
}
