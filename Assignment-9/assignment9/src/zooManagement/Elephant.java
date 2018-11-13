package zooManagement;

/**
 * Elephant is the subclass of Mammal
 * @author Prakalpa-Rathore
 */
public class Elephant extends Mammal{

	private static int id = 1; //used to maintain the unique name for elephants
	
	/**
	 * This constructor initializes the Elephant properties and calls its super to add other properties
	 * @param weight
	 * @param age
	 */
	public Elephant(double weight, int age) {
		super("Elephant" + (id++), weight, age, "Trumpet", 4, false, AnimalName.ELEPHANT);
	}

}
