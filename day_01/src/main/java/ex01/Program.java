package ex01;

import java.util.UUID;

public class Program {
	public static void main(String[] args) {

		User user;

		for (int i = 0; i < 5; i++){
			user = new User("Vasia", i);
			System.out.println(user);
		}
	}

}
