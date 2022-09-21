package ex02;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = 0;
		while (n != 42){
			boolean b = true;
			int i = 2;
			int num = 0;
			while (n > 0){
				num += n % 10;
				n /= 10;
			}
			while (i <= num / i){
				if (num % i == 0)
					b = false;
				i++;
			}
			if (b)
				res++;
			n = sc.nextInt();
		}
		System.out.print("Count of coffee - request - " + res);
		sc.close();
	}
}
