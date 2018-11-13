package zooManagement;

/**
 * This class inherits the Zone class and used to add Mammal Zone in the Zoo
 * @author Prakalpa-Rathore
 */
public class MammalZone extends Zone{
	
	/**
	 * It initializes the MammalZone properties into Zoo
	 * @param capacity
	 * @param hasPark
	 * @param hasCanteen
	 */
	public MammalZone(int capacity, boolean hasPark, boolean hasCanteen)
	{
		super(AnimalFamily.MAMMAL, capacity, hasPark, hasCanteen);
	}
}
