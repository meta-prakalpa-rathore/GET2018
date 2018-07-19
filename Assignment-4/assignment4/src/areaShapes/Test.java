package areaShapes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Area calculateArea = new Area();
		double base, width, height, radius, area;
		int choice;
		
		try
		{
		do
		{
			System.out.println("\nMENU");
			System.out.println("1. Calculate area of triangle");
			System.out.println("2. Calculate area of rectangle");
			System.out.println("3. Calculate area of square");
			System.out.println("4. Calculate area of circle");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			choice = scanner.nextInt();
			
			switch(choice)
			{
				case 1: System.out.println("Enter the value of base of triangle:");
						base = scanner.nextDouble();
						System.out.println("Enter the value of height of triangle:");
						height = scanner.nextDouble();
						area = calculateArea.areaOfTriangle(base, height);
						System.out.println("Area of triangle: " + area);
						break;
						
				case 2: System.out.println("Enter the value of width of rectangle:");
						width = scanner.nextDouble();
						System.out.println("Enter the value of height of triangle:");
						height = scanner.nextDouble();
						area = calculateArea.areaOfRectangle(width, height);
						System.out.println("Area of rectangle: " + area);
						break;
						
				case 3: System.out.println("Enter the value of width of square:");
						width = scanner.nextDouble();
						area = calculateArea.areaOfSquare(width);
						System.out.println("Area of square: " + area);
						break;
						
				case 4: System.out.println("Enter the value of radius of circle:");
						radius = scanner.nextDouble();
						area = calculateArea.areaOfCircle(radius);
						System.out.println("Area of circle: " + area);
						break;
						
				case 5: break;
				
				default: System.out.println("Wrong Input! Try Again!");
			}
		}while(choice != 5);
		}
		catch(InputMismatchException exception)
		{
			System.out.println("Wrong input type! Try again!");
			main(new String[1]);
		}
	}

}
