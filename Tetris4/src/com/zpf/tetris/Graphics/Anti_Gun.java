package com.zpf.tetris.Graphics;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.zpf.tetris.Square.Piece;
import com.zpf.tetris.Square.Square;

/* Anti_Gun graphics */
public class Anti_Gun extends Piece{
	public Anti_Gun(Image image) {
		
		/* Change one */
		List<Square> list = new ArrayList<>();
		list.add(new Square(image, 0, 0));
		list.add(new Square(image, image.getWidth(null), 0));
		list.add(new Square(image, image.getWidth(null) * 2, image.getHeight(null)));
		
		/* Change two */
		List<Square> list2 = new ArrayList<>();
		list2.add(new Square(image, image.getWidth(null), 0));
		list2.add(new Square(image, image.getWidth(null), image.getHeight(null)));
		list2.add(new Square(image, 0, image.getHeight(null) * 2));
		
		/* Change three */
		List<Square> list3 = new ArrayList<>();
		list3.add(new Square(image, 0, 0));
		list3.add(new Square(image, image.getWidth(null), image.getHeight(null)));
		list3.add(new Square(image, image.getWidth(null) * 2, image.getHeight(null)));
		
		/* Change four*/
		List<Square> list4 = new ArrayList<>();
		list4.add(new Square(image, image.getWidth(null), 0));
		list4.add(new Square(image, 0, image.getHeight(null)));
		list4.add(new Square(image, 0, image.getHeight(null) * 2));
		
		this.changes.add(list);
		this.changes.add(list2);
		this.changes.add(list3);
		this.changes.add(list4);
		
		this.setSquare(getDefault());
		
		
	}
}
