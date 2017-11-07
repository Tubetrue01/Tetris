package com.zpf.Factory.Impl;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.zpf.Factory.Factory;
import com.zpf.tetris.Graphics.Anti_Gun;
import com.zpf.tetris.Graphics.Anti_L;
import com.zpf.tetris.Graphics.Anti_Z;
import com.zpf.tetris.Graphics.Boxs;
import com.zpf.tetris.Graphics.Five;
import com.zpf.tetris.Graphics.Gun;
import com.zpf.tetris.Graphics.Heart;
import com.zpf.tetris.Graphics.L;
import com.zpf.tetris.Graphics.P;
import com.zpf.tetris.Graphics.Point;
import com.zpf.tetris.Graphics.Strip;
import com.zpf.tetris.Graphics.T;
import com.zpf.tetris.Graphics.Z;
import com.zpf.tetris.Square.Piece;
import com.zpf.tetris.Utils.Utils;

public class FactoryImpl implements Factory {

	// A hashMap to store image and it's id
	private Map<Integer, Image> images = new HashMap<>();
	// quantity of color
	private static final int COLOR_QUANTITY = 7;

	private Random random = new Random();

	@Override
	public Piece create(int x, int y, int level) {
		// Randomly a picture from map
		Image image = getImage(random.nextInt(COLOR_QUANTITY));
		Piece piece = initPiece(image, level);
		piece.setLocationX(x);
		piece.setLocationY(y);

		return piece;

	}

	/* Initialize a random piece */
	public Piece initPiece(Image image, int level) {
		
		Piece piece = null;
		
		int count = 0;
		
		switch(level) {
		case 1:
			count = 7;
			break;
		case 2:
			count = 8;
			break;
		case 3:
			count = 9;
			break;
		case 4:
			count = 10;
			break;
		case 5:
			count = 11;
			break;
		case 6:
			count = 12;
			break;
		case 7:
			count = 13;
			break;
			
		}
		
		switch ( random.nextInt(count)) {
		case 0:
			piece = new Strip(image); 
			break;
		case 1:
			piece = new L(image); 
			break;
		case 2:
			piece = new Anti_L(image); 
			break;
		case 3:
			piece = new Z(image);
			break;
		case 4:
			piece = new Anti_Z(image);
			break;
		case 5:
			piece = new T(image);
			break;
		case 6:
			piece = new Boxs(image);
			break;
		case 7:
			piece = new Point(image);
			break;
		case 8:
			piece = new Gun(image);
			break;
		case 9:
			piece = new Anti_Gun(image);
			break;
		case 10:
			piece = new P(image);
			break;
		case 11:
			piece = new Five(image);
			break;
		case 12:
			piece = new Heart(image);
			break;

		}
		return piece;
	}

	/*
	 * Return if key exists in this map, or add to the map from images and
	 * return it
	 */

	public Image getImage(int key) {
		if (images.get(key) == null) {
			Image image = Utils.getImage("images/square" + key + ".jpg");
			this.images.put(key, image);
		}
		return images.get(key);
	}
}
