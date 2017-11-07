package com.zpf.Factory;

import java.awt.Image;

import com.zpf.tetris.Square.Piece;

public interface Factory {

	/* Create piece with x and y */
	public Piece create(int x, int y, int level);
	
	/* Initialize piece by image and level */
	public Piece initPiece(Image image, int level);
	
    /* Get the image by pressing the key */
	public Image getImage(int key);

}
