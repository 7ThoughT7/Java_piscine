package ex01;

public class Program implements Runnable {

	private int cMes;
	private String mes;
	private static String key = "Hen";

	public Program(int cMes, String mes){
		this.cMes = cMes;
		this.mes = mes;
	}

	public static void main(String[] args) {

		int cMes = 0;
		String arr[] = args[0].split("=");

		if (args.length != 1){
			System.err.println("Wrong number of arguments");
			System.exit(-1);
		}

		if (!arr[0].equals("--count")){
			System.err.println("Error: wrong argument");
			System.exit(-1);
		}

		cMes = Integer.parseInt(arr[1]);
		if (cMes < 0) {
			System.err.println("Error");
			System.exit(-1);
		}

		Thread egg = new Thread(new Program(cMes, "Egg"));
		Thread hen = new Thread(new Program(cMes, "Hen"));

		egg.start();
		hen.start();
		try {
			egg.join();
			hen.join();
		}
		catch (InterruptedException ex){
			ex.printStackTrace();
		}

		for (int i = 0; i < cMes; i++) {
			System.out.println("Human");
		}
	}

	public void run(){
		int i = 0;
		while (i < cMes){
			synchronized (Program.class){
				if (!key.equals(mes)) {
					System.out.println(mes);
					key = mes;
					i++;
				}
			}
		}
	}
}
