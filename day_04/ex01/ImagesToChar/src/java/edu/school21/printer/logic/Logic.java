package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Logic {

	public static int[][] seeBMPimage(char black, char white) throws IOException {
		BufferedImage image = ImageIO.read(Objects.requireNonNull(Logic.class.getResource("/resources/it.bmp")));

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
