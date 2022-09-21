package ex00;

import java.lang.Thread;

public class Program {
	public static void main(String[] args) throws InterruptedException {
		String str = args[0];
		String s = "--count";
		String[] arr = str.split("=");
		int num = 0;

		if (args.length != 1){
			System.err.println("Wrong number of arguments");
			System.exit(-1);
		}
		else if (!arr[0].equals(s)){
			System.err.println("Args is wrong");
			System.exit(-2);
		}
		else if (arr.length == 2){
			try {
				num = Integer.parseInt(arr[1]);
			}
			catch (NumberFormatException ex) {
				System.err.println("Number is wrong");
				System.exit(-3);
			}
		}
		else{
			System.err.println("Enter the number");
			System.exit(-4);
		}

		int finalNum = num;
		Thread egg = new Thread(new Runnable() {
            @Override
            public void run() {
				for (int i = 0; i < finalNum; i++)
					System.out.println("egg");
            }
        });
        egg.start();

        Thread hen = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < finalNum; i++)
					System.out.println("hen");
			}
        });
        hen.start();

		egg.join();
		hen.join();;

		for (int i = 0; i < finalNum; i++) {
			System.out.println("human");
		}
	}
}
