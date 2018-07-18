package shoppingCart;

import java.util.ArrayList;
import java.util.List;

class Item
{
	private int id;
	private double price;
	private int quantity;
	
	public Item(int id,double price, int quantity)
	{
		this.id = id;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double total()
	{
		return price*quantity;
	}
	
	public void showItem()
	{
		System.out.println(id+"\t\t\t"+price+"\t\t"+quantity+"\t\t"+total());
	}
}


public class ShoppingCart {

	List<Item> items = new ArrayList<Item>();
	Promotion promotion;
	
	/**
	 * this method adds an item to the cart. If an item already exists, its quantity is updated
	 * @param id 
	 * @param price
	 * @param quantity
	 */
	public void addItem(int id, double price, int quantity)
	{
		boolean update = false;
		for(Item item : items)
		{
			if(item.getId()==id)
			{
				update = true;
				int q = item.getQuantity();
				item.setQuantity(quantity + q);
				break;
			}
		}
		if(!update)
		{
		Item item = new Item(id, price, quantity);
		items.add(item);
		}
	}
	
/**
 * this method removes an item from the cart
 * @param id is the product id of the product to be removed
 */
	public void removeItem(int id)
	{
		for(Item item:items)
		{
			if(id==item.getId())
			{
				items.remove(item);
				break;
			}
		}
	}
	
	/**
	 * this method generates the bill of the cart items and also applies the discount if applicable
	 * @param promoCode is the promocode as provided by user
	 */
	public void generateBill(String promoCode)
	{
		double sum=0;
		System.out.println("Product id\t\tprice\t\tquantity\ttotal");
		for(Item item:items)
		{
			item.showItem();
			sum += item.total();
		}
		
		promotion = new FixedOrderPromotion();
		promotion.setMinimumPrice(2000);
		promotion.setFixedDiscount(10);
		double discount = applyPromotion(promotion, promoCode, sum);
		System.out.println("\nTotal:" + sum);
		System.out.println("discount applied:"+discount+" %");
		sum = sum - ((discount/100)*sum);
		System.out.println("Grand Total:  " + sum);
	}
	
	/**
	 * this method generates the discount based on the promotion applied 
	 * @param promotion is an object of Promotion class
	 * @param code is a string having the promocode
	 * @param amount is the total amount of the items in the cart 
	 * @return it returns the % discount that can be applied on the order
	 */
	public double applyPromotion(Promotion promotion, String code, double amount)
	{
		double discount = 0;
		if(promotion.isPromotionApplicable(code) && amount >= promotion.getMinimumPrice())
		{
			discount = promotion.getFixedDiscount();
		}
		return discount;
	}
	
	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	
}
