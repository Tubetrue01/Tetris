package com.zpf.tetris.Graphics;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.zpf.tetris.Square.Piece;
import com.zpf.tetris.Square.Square;

/* Point graphics */
public class Point extends Piece{
	public Point(Image image) {
		List<Square> list = new ArrayList<>();
		list.add(new Square(image, 0, 0));
		
		this.changes.add(list);
		this.setSquare(getDefault());
	}
}
