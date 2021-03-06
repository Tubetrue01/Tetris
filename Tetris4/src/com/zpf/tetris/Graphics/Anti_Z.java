package com.zpf.tetris.Graphics;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.zpf.tetris.Square.Piece;
import com.zpf.tetris.Square.Square;

public class Anti_Z extends Piece{
	public Anti_Z(Image images) {
		List<Square> list = new ArrayList<>();
		list.add(new Square(images, images.getWidth(null), 0));
		list.add(new Square(images, images.getWidth(null)*2, 0));
		list.add(new Square(images, 0, images.getHeight(null)));
		list.add(new Square(images, images.getWidth(null), images.getHeight(null)));
		
		/*
		 *           *
		 *           * *
		 *             *
		 */
		List<Square> list2 = new ArrayList<>();
		list2.add(new Square(images, 0, 0));
		list2.add(new Square(images, 0, images.getHeight(null)));
		list2.add(new Square(images, images.getWidth(null), images.getHeight(null)));
		list2.add(new Square(images, images.getWidth(null), images.getHeight(null)*2));
		
		super.changes.add(list);
		super.changes.add(list2);
		
		super.setSquare(getDefault());
	}
}
