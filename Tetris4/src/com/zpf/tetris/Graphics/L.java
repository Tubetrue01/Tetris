package com.zpf.tetris.Graphics;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.zpf.tetris.Square.Piece;
import com.zpf.tetris.Square.Square;

// Graphics L
public class L extends Piece {

	public L(Image image) {

		// Change one
		List<Square> list = new ArrayList<>();
		list.add(new Square(image, 0, 0));
		list.add(new Square(image, 0, image.getHeight(null)));
		list.add(new Square(image, 0, image.getHeight(null) * 2));
		list.add(new Square(image, image.getWidth(null), image.getHeight(null) * 2));

		// Change two
		List<Square> list2 = new ArrayList<>();
		list2.add(new Square(image, 0, 0));
		list2.add(new Square(image, 0, image.getHeight(null)));
		list2.add(new Square(image, image.getWidth(null), 0));
		list2.add(new Square(image, image.getWidth(null) * 2, 0));

		// Change three
		List<Square> list3 = new ArrayList<>();
		list3.add(new Square(image, 0, 0));
		list3.add(new Square(image, image.getWidth(null), 0));
		list3.add(new Square(image, image.getWidth(null), image.getHeight(null)));
		list3.add(new Square(image, image.getWidth(null), image.getHeight(null) * 2));

		// Change four
		List<Square> list4 = new ArrayList<>();
		list4.add(new Square(image, image.getWidth(null) * 2, 0));
		list4.add(new Square(image, 0, image.getHeight(null)));
		list4.add(new Square(image, image.getWidth(null), image.getHeight(null)));
		list4.add(new Square(image, image.getWidth(null) * 2, image.getHeight(null)));
		
		// Add four changes to list
		super.changes.add(list);
		super.changes.add(list2);
		super.changes.add(list3);
		super.changes.add(list4);
		
		// get the random change
		super.setSquare(getDefault());

	}
}
