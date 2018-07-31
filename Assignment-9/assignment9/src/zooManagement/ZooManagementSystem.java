package zooManagement;

import java.util.Scanner;

/**
 * This is the main method from where zoo is managed
 * @author Prakalpa-Rathore
 */
public class ZooManagementSystem {

	public static void main(String[] args) {

		Zoo zoo = new Zoo(); // create object of zoo class
		int choice;
		
		// a while loop which is true for each situation
		do
		{
			System.out.println("MENU!!!!");
			System.out.println("1. Add Zone to the Zoo");
			System.out.println("2. Add Cage to the Zone");
			System.out.println("3. Add Animal to cage");
			System.out.println("4. Remove animal from cage");
			System.out.println("5. Exit");
			
			System.out.println("Enter your choice..");
			Scanner scanner = new Scanner(System.in);
			//validate input
            while(!scanner.hasNextInt())
            {
                System.out.println("Please enter integer value");
                scanner.next();
            }
			choice = scanner.nextInt();
			
			switch (choice) // this switch case will show various operations of zoo class
			{
			case 1: AnimalFamily zoneType = chooseZone(scanner);
					System.out.println("Please enter the capacity");
					int capacity = scanner.nextInt();
					System.out.println("Does the zone has a park? (Enter true or false)");
					boolean hasPark = scanner.nextBoolean();
					System.out.println("Does the zone has a canteen? (Enter true or false)");
					boolean hasCanteen = scanner.nextBoolean();
			
					zoo.addZone(zoneType, capacity, hasPark, hasCanteen);
					break;
			
			case 2: AnimalName cageType = chooseCage(scanner);
					System.out.println("Enter the capacity of the cage");
					int capacityOfCage = scanner.nextInt();
		
					if(zoo.addCage(cageType, capacityOfCage))
					{
						System.out.println("Cage is successfully added");
					}
					break;
		    
			case 3: AnimalName animalType = chooseCage(scanner);
			        Animal animal = addNewAnimal(scanner, animalType);
					if(zoo.addAnimal(animal))
						System.out.println("Animal added successfully");
					break;
			
			case 4: AnimalName animalType1 = chooseCage(scanner);
					if(zoo.removeAnimal(animalType1))
						System.out.println("Remove successfully");
					break;
					
			case 5: break;
			
			default:System.out.println("Wrong input! Try again!");
			
			}
		}while(choice != 5);
	}
	

	/**
	 * This will create a animal object to add animal
	 * @param sc
	 * @param animalType
	 * @return animal object
	 */
	private static Animal addNewAnimal(Scanner sc, AnimalName animalType) {
		
		Animal animal = null;
		double weight;
		int age;
		double wingSpan;
		switch(animalType)
		{
		case CROCODILE: System.out.println("Enter the weight and age of crocodile");
		     weight = sc.nextDouble();
		     age = sc.nextInt();
		     animal = new Crocodile(weight, age);
			 break;
			
		case ELEPHANT: System.out.println("Enter the weight and age of elephant");
	         weight = sc.nextDouble();
	         age = sc.nextInt();
	         animal = new Elephant(weight, age);
			 break;
			
		case LION: System.out.println("Enter the weight and age of Lion");
	         weight = sc.nextDouble();
	         age = sc.nextInt();
	         animal = new Lion(weight, age);
			 break;
			
		case PARROT: System.out.println("Enter the weight, age and wing span of Parrot");
	         weight = sc.nextDouble();
	         age = sc.nextInt();
	         wingSpan = sc.nextDouble();
	         animal = new Parrot(weight, age, wingSpan);
			 break;
			
		case PEACOCK:System.out.println("Enter the weight, age and wing span of Peacock");
	         weight = sc.nextDouble();
	         age = sc.nextInt();
	         wingSpan = sc.nextDouble();
	         animal = new Peacock(weight, age, wingSpan);
			 break;
			
		case SNAKE: System.out.println("Enter the weight and age of snake");
	         weight = sc.nextDouble();
	         age = sc.nextInt();
	         animal = new Snake(weight, age);
		   	 break;
			
		}
		return animal;
	}
	

	/**
	 * Used to find animal name
	 * @param sc
	 * @return
	 */
	private static AnimalName chooseCage(Scanner sc) {
		AnimalName cageType = null;
		System.out.println("List of Cage Types");
	    System.out.println("1. Lion");
	    System.out.println("2. Elephant");
	    System.out.println("3. Parrot");
	    System.out.println("4. Peacock");
	    System.out.println("5. Snake");
	    System.out.println("6. Crocodile");
	    System.out.println("Choose from the cage types..");
	    
	    int cage = sc.nextInt();
	    
	    switch(cage)
	    {
	    case 1: 
	    	cageType = AnimalName.LION;
	    	break;
	    case 2: 
	    	cageType = AnimalName.ELEPHANT;
	    	break;
	    case 3: 
	    	cageType = AnimalName.PARROT;
	    	break;
	    case 4: 
	    	cageType = AnimalName.PEACOCK;
	    	break;
	    case 5: 
	    	cageType = AnimalName.SNAKE;
	    	break;
	    case 6: 
	    	cageType = AnimalName.CROCODILE;
	    	break;
	    default:
			System.out.println("No result found!!");
			break;	
	    }
		return cageType;
	}

	
	/**
	 * this method is used to choose the category of the animal
	 * @param sc
	 * @return
	 */
	private static AnimalFamily chooseZone(Scanner sc) {
		
		AnimalFamily zoneType = null;
		System.out.println("List of Zones");
	    System.out.println("1. Bird");
	    System.out.println("2. Mammal");
	    System.out.println("3. Reptile");
	    System.out.println("Choose from the zone types..");
	    
	    int zone = sc.nextInt();
	    
	    switch (zone) {
		case 1:
			zoneType = AnimalFamily.BIRD;
			break;
		case 2:
			zoneType = AnimalFamily.MAMMAL;
			break;
		case 3:
			zoneType = AnimalFamily.REPTILE;
			break;
		default:
			System.out.println("No result found!!");
			break;
		}
		return zoneType;
	}

}
