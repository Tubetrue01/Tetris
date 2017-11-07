package com.zpf.tetris.Graphics;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.zpf.tetris.Square.Piece;
import com.zpf.tetris.Square.Square;

public class Heart extends Piece{
	public Heart(Image image) {
		List<Square> list = new ArrayList<>();
		list.add(new Square(image, image.getWidth(null), 0));
		list.add(new Square(image, image.getWidth(null) * 3, 0));
		list.add(new Square(image, 0, image.getHeight(null)));
		list.add(new Square(image, image.getWidth(null) * 2, image.getHeight(null)));
		list.add(new Square(image, image.getWidth(null) * 4, image.getHeight(null)));
		list.add(new Square(image, 0, image.getHeight(null) * 2));
		list.add(new Square(image, image.getWidth(null) * 4, image.getHeight(null) *2));
		list.add(new Square(image, image.getWidth(null), image.getHeight(null) * 3));
		list.add(new Square(image, image.getWidth(null) * 3, image.getHeight(null) * 3));
		list.add(new Square(image, image.getWidth(null) * 2, image.getHeight(null) * 4));
		
		this.changes.add(list);
		this.setSquare(list);
	}
}
