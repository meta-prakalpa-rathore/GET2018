package zooManagement;

/**
 * Lion is the subclass of Mammal
 * @author Prakalpa-Rathore
 */
public class Lion extends Mammal{

private static int id = 1; //used to maintain the unique name for lions
	
    /**
     * This initializes Lion and calls its super to add other properties
     * @param weight
     * @param age
     */
	public Lion(double weight, int age) {
		super("Lion" + (id++), weight, age, "Roar", 4, false, AnimalName.LION);
	}

}
