package Basics;
public class Narrowing {
	public static void main(String[] args) {
		short num=5;
		int numb = num;
		System.out.println("Widening Number is "+numb);
		
		long num1 = 199;
		int numb1 = (int) num1;
		System.out.println("Narrowing number is "+numb1);
	}
}
