package com.zpf.tetris.Graphics;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.zpf.tetris.Square.Piece;
import com.zpf.tetris.Square.Square;

// Graphics strip
public class Strip extends Piece {

	public Strip(Image image) {
		// Change one
		List<Square> list = new ArrayList<>();
		list.add(new Square(image, 0, 0));
		list.add(new Square(image, 0, image.getHeight(null)));
		list.add(new Square(image, 0, image.getHeight(null) * 2));
		list.add(new Square(image, 0, image.getHeight(null) * 3));

		// Change two
		List<Square> list2 = new ArrayList<>();
		list2.add(new Square(image, 0, 0));
		list2.add(new Square(image, image.getWidth(null), 0));
		list2.add(new Square(image, image.getWidth(null) * 2, 0));
		list2.add(new Square(image, image.getWidth(null) * 3, 0));

		// Add to the changes list
		super.changes.add(list);
		super.changes.add(list2);
		
		// Randomly generate a style
		super.setSquare(getDefault());
	}
}
