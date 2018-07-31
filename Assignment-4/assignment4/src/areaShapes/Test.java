package areaShapes;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Area calculateArea = new Area();
		double base, width, height, radius, area;
		int choice;
		
		do
		{
			System.out.println("\nMENU");
			System.out.println("1. Calculate area of triangle");
			System.out.println("2. Calculate area of rectangle");
			System.out.println("3. Calculate area of square");
			System.out.println("4. Calculate area of circle");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			//validate input
            while(!scanner.hasNextInt())
            {
                System.out.println("Please enter integer value");
                scanner.next();
            }
			choice = scanner.nextInt();
			
			switch(choice)
			{
				case 1: System.out.println("Enter the value of base of triangle:");
				        //validate input
                        while(!scanner.hasNextDouble())
                        {
                            System.out.println("Please enter decimal value");
                            scanner.next();
                        }
						base = scanner.nextDouble();
						System.out.println("Enter the value of height of triangle:");
						//validate input
                        while(!scanner.hasNextDouble())
                        {
                            System.out.println("Please enter decimal value");
                            scanner.next();
                        }
						height = scanner.nextDouble();
						area = calculateArea.areaOfTriangle(base, height);
						System.out.println("Area of triangle: " + area);
						break;
						
				case 2: System.out.println("Enter the value of width of rectangle:");
				        //validate input
                        while(!scanner.hasNextDouble())
                        {
                            System.out.println("Please enter decimal value");
                            scanner.next();
                        }
						width = scanner.nextDouble();
						System.out.println("Enter the value of height of triangle:");
						//validate input
                        while(!scanner.hasNextDouble())
                        {
                            System.out.println("Please enter decimal value");
                            scanner.next();
                        }
						height = scanner.nextDouble();
						area = calculateArea.areaOfRectangle(width, height);
						System.out.println("Area of rectangle: " + area);
						break;
						
				case 3: System.out.println("Enter the value of width of square:");
				        //validate input
                        while(!scanner.hasNextDouble())
                        {
                            System.out.println("Please enter decimal value");
                            scanner.next();
                        }
						width = scanner.nextDouble();
						area = calculateArea.areaOfSquare(width);
						System.out.println("Area of square: " + area);
						break;
						
				case 4: System.out.println("Enter the value of radius of circle:");
				        //validate input
                        while(!scanner.hasNextDouble())
                        {
                            System.out.println("Please enter decimal value");
                            scanner.next();
                        }
						radius = scanner.nextDouble();
						area = calculateArea.areaOfCircle(radius);
						System.out.println("Area of circle: " + area);
						break;
						
				case 5: break;
				
				default: System.out.println("Wrong Input! Try Again!");
			}
			
		}while(choice != 5);
	}

}
