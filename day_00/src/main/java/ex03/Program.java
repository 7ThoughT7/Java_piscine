package ex03;

import java.util.Scanner;

public class Program {

	private static final String BUF = "=";
	private static final String WEEK = "Week ";
	private static final String SP1 = " ";
	private static final String SP2 = "  ";


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = 0;
		long weeks = 0;
		String str = sc.nextLine();
		while (!str.equals("42")){
			if (str.equals("Week " + (++w))){
				long min = 10;
				for (int i = 0; i < 5; i++) {
					if (!sc.hasNextInt())
						System.exit(-1);
					int c = sc.nextInt();
					if (c < min && c > 0)
						min = c;
					else if (c < 1 || c > 9){
						System.err.print("IllegalArgument");
						sc.close();
						System.exit(-1);
					}
				}
				for (int i = 0; i < w - 1; i++)
					min *= 10;
				weeks += min;
				sc.nextLine();
			}
			else {
				System.err.print("IllegalArgument");
				sc.close();
				System.exit(-1);
			}
			str = sc.nextLine();
		}
		sc.close();
		int num_w = 1;
		while (weeks > 0){
			if (num_w < 10) {
				System.out.print(WEEK);
				System.out.print(num_w++);
				System.out.print(SP2);
			}
			else {
				System.out.print(WEEK);
				System.out.print(num_w++);
				System.out.print(SP1);
			}
			long i = weeks % 10;
			for (int j = 0; j < i; j++)
				System.out.print(BUF);
			System.out.println(">");
			weeks /= 10;
		}
	}
}
