package zooManagement;

/**
 * This class inherits the Animal class
 * @author Prakalpa-Rathore
 */
public class Mammal extends Animal{
	
	private final boolean hasFurs;
	
	/**
	 * The constructor initializes the Mammals in the Zoo
     * It calls its super class constructor to initialize the basic animal properties 
	 * @param name
	 * @param weight
	 * @param age
	 * @param sound
	 * @param numberOfLegs
	 * @param hasFurs
	 * @param animalType
	 */
	public Mammal(String name, double weight, int age, String sound,
			int numberOfLegs, boolean hasFurs, AnimalName animalType) {
		
		super(name, weight, age, sound, numberOfLegs, AnimalFamily.MAMMAL, animalType);
		
		this.hasFurs = hasFurs;
	}

	public boolean hasFurs() {
		return hasFurs;
	}
}
