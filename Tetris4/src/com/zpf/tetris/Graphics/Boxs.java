package com.zpf.tetris.Graphics;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.zpf.tetris.Square.Piece;
import com.zpf.tetris.Square.Square;

// a square graphics
public class Boxs extends Piece {

	public Boxs(Image image) {
		List<Square> list = new ArrayList<>();
		list.add(new Square(image, 0, 0));
		list.add(new Square(image, 0, image.getHeight(null)));
		list.add(new Square(image, image.getWidth(null), 0));
		list.add(new Square(image, image.getWidth(null), image.getHeight(null)));

		super.changes.add(list);
		super.setSquare(list);
	}
}
