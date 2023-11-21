package Basics;

public class Overloading {
	public static void main(String[] Args) {
		System.out.println("Price of ten shirts: "+priceOfTenShirts(599));
		System.out.println("10% discount: "+ discountOnShirts(599,10));
		System.out.println("25% discount: "+ discountOnShirts(599,25));
	}
	static int priceOfTenShirts(int price) {
		return price*10;
	}
	static double discountOnShirts(int price, int discount) {
		return price - price*discount/100.0;
	}
	static double discountOnShirts(double price, int discount) {
		return price - price*discount/100;
	}
}
