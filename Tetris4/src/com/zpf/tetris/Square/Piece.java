package com.zpf.tetris.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Piece {

	// Used to store graphics
	protected List<Square> square;
	// all of changes
	protected List<List<Square>> changes = new ArrayList<>();
	// create random object
	private Random random = new Random();
	// border of each square
	public static final int SQUARE_BORDER = 16;
	// current index
	private int currentIndex = 0;

	public List<Square> getSquare() {
		return square;
	}

	public void setSquare(List<Square> square) {
		this.square = square;
	}

	/* Randomly generate a square */
	public List<Square> getDefault() {
		// according to size of changes to randomly generate a number as the
		// current index
		this.currentIndex = random.nextInt(changes.size());
		return changes.get(currentIndex);

	}

	/* Change the form */
	public void change() {

		if (changes.size() == 0)
			return;
		this.currentIndex += 1;

		// set cureentIndex to zero if currentIndex out of size of list
		if (this.currentIndex >= this.changes.size())
			this.currentIndex = 0;
		this.square = this.changes.get(this.currentIndex);
	}

	/* Set the X coordinates of each box */
	public void setLocationX(int x) {
		Square square;
		for (int i = 0; i < changes.size(); i++) {
			List<Square> list = changes.get(i);
			for (int j = 0; j < list.size(); j++) {
				square = list.get(j);
				square.setBeginX(square.getBeginX() + x);
			}
		}
	}

	/* Set the Y coordinates of each box */
	public void setLocationY(int y) {
		Square square;
		for (int i = 0; i < changes.size(); i++) {
			List<Square> list = changes.get(i);
			for (int j = 0; j < list.size(); j++) {
				square = list.get(j);
				square.setBeginY(square.getBeginY() + y);
			}
		}
	}

	/* Get the max X coordinates */
	public int getMaxXLoaction() {
		int result = 0;
		for (int i = 0; i < this.square.size(); i++) {
			Square square = this.square.get(i);
			if (square.getBeginX() > result)
				result = square.getBeginX();
		}
		return result + SQUARE_BORDER + 6;
	}

	/* Get the min X coordinates */
	public int getMinXLocation() {
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < this.square.size(); i++) {
			Square s = this.square.get(i);
			if (s.getBeginX() < result)
				result = s.getBeginX();
		}
		return result;
	}

	/* Get the max Y coordinates */
	public int getMaxYLoaction() {
		int result = 0;
		for (int i = 0; i < this.square.size(); i++) {
			Square square = this.square.get(i);
			if (square.getBeginY() > result)
				result = square.getBeginY();
		}
		return result + SQUARE_BORDER + 16;
	}

	/* Get the min Y coordinates */
	public int getMinYLocation() {
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < this.square.size(); i++) {
			Square square = this.square.get(i);
			if (square.getBeginY() < result)
				result = square.getBeginY();
		}
		return result;
	}
}
