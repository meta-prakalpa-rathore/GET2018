package zooManagement;

/**
 * This class inherits the Zone class and used to add Bird Zone in the Zoo
 * @author Prakalpa-Rathore
 */
public class BirdZone extends Zone{

    /**
     * It initializes the BirdZone properties into Zoo
     * @param capacity
     * @param hasPark
     * @param hasCanteen
     */
	public BirdZone(int capacity, boolean hasPark, boolean hasCanteen)
	{
		super(AnimalFamily.BIRD, capacity, hasPark, hasCanteen);
	}
	
}
