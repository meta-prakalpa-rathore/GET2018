package assignment1;

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
	
	public void addItem(int id, double price, int quantity)
	{
		int update = 0;
		for(Item i : items)
		{
			if(i.getId()==id)
			{
				update = 1;
				int q = i.getQuantity();
				i.setQuantity(quantity + q);
				break;
			}
		}
		if(update == 0)
		{
		Item item = new Item(id, price, quantity);
		items.add(item);
		}
	}
	
	public void removeItem(int id)
	{
		for(Item i:items)
		{
			if(id==i.getId())
			{
				items.remove(i);
				break;
			}
		}
	}
	
	public void generateBill()
	{
		double sum=0;
		System.out.println("Product id\t\tprice\t\tquantity\ttotal");
		for(Item i:items)
		{
			i.showItem();
			sum += i.total();
		}
		System.out.println();
		System.out.println("Grand Total:  " + sum);
	}
	
}
