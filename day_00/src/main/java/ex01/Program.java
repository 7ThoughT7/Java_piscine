package ex01;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int i = 2;
		boolean b = true;
		if (c > 1){
			while (i <= c / i){
				if (c % i == 0) {
					System.out.print("false " + (i - 1));
					sc.close();
					b = false;
					break;
				}
				else
					i++;
			}
			if (b == true) {
				System.out.print("true " + (i - 1));
				sc.close();
			}
		}
		else {
			System.err.print("Illegal Argument");
			sc.close();
			System.exit(-1);
		}
	}
}
