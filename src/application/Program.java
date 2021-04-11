package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program 
{
	public static void main(String[] args) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		
		System.out.print("Enter the number of products: ");
		int nProducts = sc.nextInt();
		System.out.println();
		
		
		for(int i=1; i<=nProducts; i++)
		{
			System.out.println("Product #" + i + " data:");
			System.out.print("-» Common, Used or Imported (c/u/i) ? ");
			char typeProduct = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("-» Name: ");
			String name = sc.nextLine();
			
			System.out.print("-» Price: ");
			double price = sc.nextDouble();
			
			if(typeProduct == 'i' || typeProduct == 'I')
			{
				System.out.print("-» Customs Fee: ");
				double customsFee = sc.nextDouble();
				
				list.add(new ImportedProduct(name, price, customsFee));
			}
			else if(typeProduct == 'u' || typeProduct == 'U')
			{
				System.out.print("-» Manufacture date (DD/MM/YYYY): ");
				Date manufacturedDate = sdf.parse(sc.next());
				
				list.add(new UsedProduct(name, price, manufacturedDate));
			}
			else
			{
				list.add(new Product(name, price));
			}
			
			System.out.println();
		}
		
		System.out.println("PRICE TAGS: ");
		for(Product p : list)
		{
			System.out.println(p.priceTag());
		
		}
		sc.close();
	}
	
}
