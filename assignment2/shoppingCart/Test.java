package shoppingCart;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		ShoppingCart cart = new ShoppingCart();
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
					
			case 3: System.out.println("Do you have a promo code?(y/n)");
					char response = sc.next().charAt(0);
					String promoCode = "";
					if(response == 'y')
					{
						System.out.println("Enter the promo code");
						promoCode = sc.next();
					}
					cart.generateBill(promoCode);
					break;
					
			case 4: break;
			
			default: System.out.println("Wrong input!! Try again!!");
			
			}
		}while(choice != 4);

	}

}
