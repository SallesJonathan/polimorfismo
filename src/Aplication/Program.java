package Aplication;

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

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> product = new ArrayList<>();

		System.out.print("Enter the number of products:");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char ch = sc.next().charAt(0);
			System.out.println("name: ");
			String name = sc.next();
			System.out.println("price: ");
			double price = sc.nextDouble();

			if (ch == 'c') {
				product.add(new Product(name, price));

			}else if(ch == 'u') {
				System.out.println("Manufacture date (DD/MM/YYYY):");
				Date date = sdf1.parse(sc.next());
				product.add(new UsedProduct(name, price, date));
			} else {
				System.out.println("Customs fee:");
				double custom = sc.nextDouble();
				product.add(new ImportedProduct(name, price, custom));
			}
		}
		System.out.println("");
		System.out.println("PRICE TAGS:");

		for (Product p : product) {
			System.out.println(" " + p.priceTag());
		}

		sc.close();
	}
}

