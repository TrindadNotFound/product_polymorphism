package entities;

import java.util.Date;

public class UsedProduct extends Product
{
	private Date manufacturedDate;
	
	public UsedProduct()
	{
		super();
	}
	
	
	public UsedProduct(String name, Double price, Date manufacturedDate)
	{
		super(name, price);
		this.manufacturedDate = manufacturedDate;
	}
	
	
	public Date getManufacturedDate()
	{
		return manufacturedDate;
	}
	
	public void setManufacturedDate(Date manufacturedDate)
	{
		this.manufacturedDate = manufacturedDate;
	}
	
	
	public String priceTag()
	{
		return super.getName() + " (Used) " + super.getPrice() + " €" + " (Manufactured date: " + manufacturedDate + ")";
	}
	
}
