package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Logic {

	public static int[][] seeBMPImage(String fileName, char black, char white) throws IOException {
		BufferedImage image = ImageIO.read(new FileInputStream(fileName));

		int[][] arr = new int[image.getHeight()][image.getWidth()];
		for (int x = 0; x < image.getHeight(); x++) {
			for (int y = 0; y < image.getWidth(); y++) {
				int color = image.getRGB(y, x);
				if (color == Color.BLACK.getRGB())
					arr[x][y] = black;
				else if (color == Color.WHITE.getRGB())
					arr[x][y] = white;
			}
		}
		return arr;
	}
}
