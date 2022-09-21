package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import java.io.IOException;

public class Program  {
	public static void main(String[] args) throws IOException {

		if (args.length != 3){
			System.err.println("Wrong number is args");
			System.exit(-1);
		}
		char white = args[0].charAt(0);
		char black = args[1].charAt(0);
		String path = args[2];

		int[][] arr = Logic.seeBMPImage(path, black, white);
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[0].length; y++)
				System.out.print((char) arr[x][y]);
			System.out.println();
		}
	}
}
