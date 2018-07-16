package assignment1;

import java.util.Scanner;

class Test {
	public static void main (String arg[])
	{
		//Uncomment following code to test StackArray.java
		
		/*StackArray obj = new StackArray();
		int choice,val;
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("MENU");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Top Value");
			System.out.println("4. Is the stack Empty?");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1: System.out.println("Enter value to be pushed:");
						val=sc.nextInt();
						obj.push(val);
						break;
						
				case 2: val=obj.pop();
						if(val!=-1)
							System.out.println("The popped value is: "+val);
						break;
						
				case 3: if(!obj.isEmpty())
						{	
							val=obj.topValue();
							System.out.println("The top value is: "+val);
						}
						else
							System.out.println("The stack is empty!");
						break;
						
				case 4: boolean isempty=obj.isEmpty();
						if(isempty==true)
							System.out.println("The stack is empty");
						else
							System.out.println("The stack is not empty");
						break;
						
				case 5: break;
				
				default: System.out.println("Wrong choice!! Please select correct option");
			}
		}while(choice!=5);*/
		
		
		
		
		
		
		
		
		
		
		
		//Uncomment following code to test StackLinkedList.java
		
		/*StackLinkedList obj = new StackLinkedList();
		int choice,val;
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("MENU");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Top Value");
			System.out.println("4. Is the stack Empty?");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1: System.out.println("Enter value to be pushed:");
						val=sc.nextInt();
						obj.push(val);
						break;
						
				case 2: val=obj.pop();
						if(val!=-1)
							System.out.println("The popped value is: "+val);
						break;
						
				case 3: if(!obj.isEmpty())
						{	
							val=obj.topValue();
							System.out.println("The top value is: "+val);
						}
						else
							System.out.println("The stack is empty!");
						break;
						
				case 4: boolean isempty=obj.isEmpty();
						if(isempty==true)
							System.out.println("The stack is empty");
						else
							System.out.println("The stack is not empty");
						break;
						
				case 5: break;
				
				default: System.out.println("Wrong choice!! Please select correct option");
			}
		}while(choice!=5);*/
		
		
		
		
		
		
		
		
		
		
		
		
		//Uncomment following code to test Palindrom.java
		
		/*Palindrom obj = new Palindrom();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a string:");
		String s = sc.nextLine();
		boolean ans=obj.checkPalindrom(s);
		if(ans==true)
			System.out.println(s+" is a palindrom");
		else
			System.out.println(s+" is not a palindrom");*/
		
		
		
		
		
		
		
		
		
		
		//Uncomment following code to test ShoppingCart.java
		
		/*ShoppingCart cart = new ShoppingCart();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do
		{
			System.out.println("MENU");
			System.out.println("1. Add item to cart");
			System.out.println("2. Remove item from cart");
			System.out.println("3. Generate bill");
			System.out.println("4. Exit");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1: System.out.println("Enter the product id, price, quantity of the item");
					int id = sc.nextInt();
					double price = sc.nextDouble();
					int quantity = sc.nextInt();
					cart.addItem(id, price, quantity);
					break;
					
			case 2: System.out.println("Enter the product id of the item to be removed:");
					int id1 = sc.nextInt();
					cart.removeItem(id1);
					break;
					
			case 3: cart.generateBill();
					break;
					
			case 4: break;
			
			default: System.out.println("Wrong input!! Try again!!");
			
			}
		}while(choice != 4);*/
//
	}
}
