package zooManagement;

/**
 * The class is the subclass of the Reptile class
 * @author Prakalpa-Rathore
 */
public class Crocodile extends Reptile{

	static int id = 1; //used to maintain the unique name for crocodiles
	
	/**
	 * It initializes the crocodile properties and calls its super to add other properties
	 * @param weight
	 * @param age
	 */
	public Crocodile(double weight, int age) {
		
		super("Crocodile" + (id++), weight, age, "Roar", 4, false, "warm", AnimalName.CROCODILE);
	}

}
