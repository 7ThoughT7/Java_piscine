package ex00;

public class Program {
	public static void main(String[] args) {
		int c = 479598;
		int number = 0;
		number += c % 10;
		c /= 10;
		number += c % 10;
		c /= 10;
		number += c % 10;
		c /= 10;
		number += c % 10;
		c /= 10;
		number += c % 10;
		c /= 10;
		number += c % 10;
		System.out.print(number);
	}
}
