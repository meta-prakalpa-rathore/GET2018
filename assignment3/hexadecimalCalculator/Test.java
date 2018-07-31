package hexadecimalCalculator;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		HexCalc hexCalculator = new HexCalc();
		Scanner scanner = new Scanner(System.in);
		String hexNumber1, hexNumber2, result;
		int choice;
		
		do
		{
			System.out.println("\nMENU");
			System.out.println("1. Add");
			System.out.println("2. Subtract");
			System.out.println("3. Multiply");
			System.out.println("4. Divide");
			System.out.println("5. Check for equality");
			System.out.println("6. Is greater?");
			System.out.println("7. Is smaller?");
			System.out.println("8. Convert to decimal");
			System.out.println("9. Convert to hexadecimal");
			System.out.println("10. Exit");
			System.out.println("Enter your choice:");
			choice = scanner.nextInt();
			
			switch(choice)
			{
			case 1: System.out.println("Please enter first hexadecimal number:");
					hexNumber1 = scanner.next();
					System.out.println("Please enter second hexadecimal number:");
					hexNumber2 = scanner.next();
					result = hexCalculator.add(hexNumber1.toUpperCase(), hexNumber2.toUpperCase());
					System.out.println("The result after addition is: "+ result);
					break;
					
			case 2: System.out.println("Please enter first hexadecimal number:");
					hexNumber1 = scanner.next();
					System.out.println("Please enter second hexadecimal number:");
					hexNumber2 = scanner.next();
					result = hexCalculator.subtract(hexNumber1.toUpperCase(), hexNumber2.toUpperCase());
					System.out.println("The result after subtraction is: "+ result);
					break;
					
			case 3: System.out.println("Please enter first hexadecimal number:");
					hexNumber1 = scanner.next();
					System.out.println("Please enter second hexadecimal number:");
					hexNumber2 = scanner.next();
					result = hexCalculator.multiply(hexNumber1.toUpperCase(), hexNumber2.toUpperCase());
					System.out.println("The result after multiplication is: "+ result);
					break;
					
			case 4: System.out.println("Please enter hexadecimal numerator:");
					hexNumber1 = scanner.next();
					System.out.println("Please enter hexadecimal denominator:");
					hexNumber2 = scanner.next();
					result = hexCalculator.divide(hexNumber1.toUpperCase(), hexNumber2.toUpperCase());
					System.out.println("The result after division is: "+ result);
					break;
					
			case 5: System.out.println("Please enter first hexadecimal number:");
					hexNumber1 = scanner.next();
					System.out.println("Please enter second hexadecimal number:");
					hexNumber2 = scanner.next();
					boolean isEqual = hexCalculator.equal(hexNumber1.toUpperCase(), hexNumber2.toUpperCase());
					if(isEqual)
						System.out.println("The numbers are equal.");
					else
						System.out.println("The numbers are not equal.");
					break;
					
			case 6: System.out.println("Please enter first hexadecimal number:");
					hexNumber1 = scanner.next();
					System.out.println("Please enter second hexadecimal number:");
					hexNumber2 = scanner.next();
					boolean isGreater = hexCalculator.greaterThan(hexNumber1.toUpperCase(), hexNumber2.toUpperCase());
					if(isGreater)
						System.out.println(hexNumber1 + " is greater than " + hexNumber2);
					else
						System.out.println(hexNumber1 + " is not greater than " + hexNumber2);
					break;
					
			case 7: System.out.println("Please enter first hexadecimal number:");
					hexNumber1 = scanner.next();
					System.out.println("Please enter second hexadecimal number:");
					hexNumber2 = scanner.next();
					boolean isSmaller = hexCalculator.lessThan(hexNumber1.toUpperCase(), hexNumber2.toUpperCase());
					if(isSmaller)
						System.out.println(hexNumber1 + " is smaller than " + hexNumber2);
					else
						System.out.println(hexNumber1 + " is not smaller than " + hexNumber2);
					break;
					
			case 8: System.out.println("Please enter a hexadecimal number:");
					hexNumber1 = scanner.next();
					int decimalNumber = hexCalculator.hexaToDecimal(hexNumber1.toUpperCase());
					System.out.println("The decimal equivalent of "+ hexNumber1 +" is "+ decimalNumber);
					break;
					
			case 9: System.out.println("Please enter a decimal number:");
					int decimalNum = scanner.nextInt();
					hexNumber1 = hexCalculator.decimalToHexa(decimalNum);
					System.out.println("The hexadecimal equivalent of "+ decimalNum +" is "+ hexNumber1);
					break;
					
			case 10:break;
			
			default: System.out.println("Wrong input!! Try again!!");
			
			}
		}while(choice != 10);
		
	}
}
