package zooManagement;

/**
 * The class is the subclass of the Reptile class
 * @author Prakalpa-Rathore
 */
public class Snake extends Reptile{

	static int id = 1; //used to maintain the unique name for snakes
	
	/**
	 * It initializes the snake properties and calls its super to add other properties
	 * @param weight
	 * @param age
	 */
	public Snake(double weight, int age) {
		
		super("Snake" + (id++), weight, age, "Hiss", 0, true, "cold", AnimalName.SNAKE);
	}

}
