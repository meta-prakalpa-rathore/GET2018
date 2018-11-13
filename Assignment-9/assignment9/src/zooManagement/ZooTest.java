package zooManagement;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZooTest {

    /**
     * test for adding zones in the zoo
     */
    @Test
    public void addZoneTest() {
        Zoo zoo = new Zoo();
        assertTrue(zoo.addZone(AnimalFamily.MAMMAL, 2, true, true));
        assertTrue(zoo.addZone(AnimalFamily.BIRD, 2, false, true));
        assertTrue(zoo.addZone(AnimalFamily.REPTILE, 2, false, false));
        assertTrue(zoo.addZone(AnimalFamily.BIRD, 2, false, true));
    }
    
    
    /**
     * test for adding cage in the zoo when compatible zone is present
     */
    @Test
    public void addCageTest1() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalFamily.MAMMAL, 2, true, true);
        assertTrue(zoo.addCage(AnimalName.LION, 3));
    }
    
    
    /**
     * test for adding cage in the zoo when compatible zone is not present
     */
    @Test(expected = AssertionError.class)
    public void addCageTest2() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalFamily.BIRD, 2, true, true);
        zoo.addCage(AnimalName.LION, 3);
    }
    
    
    /**
     * test for adding cages in the zoo exceeding the capacity of the zone
     */
    @Test(expected = AssertionError.class)
    public void addCageTest3() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalFamily.MAMMAL, 2, true, true);
        zoo.addCage(AnimalName.LION, 3);
        zoo.addCage(AnimalName.LION, 3);
        zoo.addCage(AnimalName.LION, 3); //adding the third cage when capacity of zone is two
    }
    
    
    /**
     * test for adding an animal(lion in this case) in the zoo when compatible cage is present
     */
    @Test
    public void addAnimalTest1() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalFamily.MAMMAL, 2, true, true);
        zoo.addCage(AnimalName.LION, 3);
        assertTrue(zoo.addAnimal(new Lion(25, 12)));
    }
    

    /**
     * test for adding an animal(lion in this case) in the zoo when compatible cage is not present
     */
    @Test(expected = AssertionError.class)
    public void addAnimalTest2() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalFamily.MAMMAL, 2, true, true);
        zoo.addCage(AnimalName.ELEPHANT, 3);
        assertTrue(zoo.addAnimal(new Lion(25, 12)));
    }
    
    
    
    /**
     * test for adding animals(elephant in this case) in the zoo exceeding the capacity of the cage
     */
    @Test(expected = AssertionError.class)
    public void addAnimalTest3() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalFamily.MAMMAL, 2, true, true);
        zoo.addCage(AnimalName.ELEPHANT, 3);
        zoo.addAnimal(new Elephant(250, 12));
        zoo.addAnimal(new Elephant(180, 10));
        zoo.addAnimal(new Elephant(25, 2));
        zoo.addAnimal(new Elephant(25, 2)); //adding the fourth elephant when capacity of cage is three
    }
    
    
    
    /**
     * test to remove an animal from the zoo when it is present
     */
    @Test
    public void removeAnimalTest1() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalFamily.MAMMAL, 2, true, true);
        zoo.addCage(AnimalName.LION, 3);
        zoo.addAnimal(new Lion(25, 12));
        assertTrue(zoo.removeAnimal(AnimalName.LION));
    }
    
    
    
    /**
     * test to remove an animal from the zoo when it is not present
     */
    @Test(expected = AssertionError.class)
    public void removeAnimalTest2() {
        Zoo zoo = new Zoo();
        zoo.addZone(AnimalFamily.MAMMAL, 2, true, true);
        zoo.addCage(AnimalName.LION, 3);
        zoo.addAnimal(new Lion(25, 12));
        zoo.removeAnimal(AnimalName.ELEPHANT);
    }
    
}
