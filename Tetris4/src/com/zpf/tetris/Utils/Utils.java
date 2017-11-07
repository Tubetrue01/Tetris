package com.zpf.tetris.Utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.zpf.tetris.Square.Piece;
import com.zpf.tetris.Square.Square;
import com.zpf.tetris.exception.GameException;

public class Utils {

	/* According path of image to load image */
	public static BufferedImage getImage(String path) {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			throw new GameException("Image load Exception!");
		}
	}

	/* Draw the graphics */
	public static void paintPiece(Graphics g, Piece p) {
		if (p == null)
			return;
		for (int i = 0; i < p.getSquare().size(); i++) {
			Square square = p.getSquare().get(i);
			g.drawImage(square.getImage(), square.getBeginX(), square.getBeginY(), null);
		}
	}
}
