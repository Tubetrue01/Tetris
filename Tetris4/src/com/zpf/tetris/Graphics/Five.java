package com.zpf.tetris.Graphics;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.zpf.tetris.Square.Piece;
import com.zpf.tetris.Square.Square;

public class Five extends Piece{
	public Five(Image image) {
		
		List<Square> list = new ArrayList<>();
		list.add(new Square(image, 0, 0));
		list.add(new Square(image, image.getWidth(null) * 2, 0));
		list.add(new Square(image, image.getWidth(null), image.getHeight(null)));
		list.add(new Square(image, 0, image.getHeight(null) * 2));
		list.add(new Square(image, image.getWidth(null) * 2, image.getHeight(null) * 2));
		
		this.changes.add(list);
		this.setSquare(getDefault());
	}

}
