package com.zpf.Task;

import java.util.TimerTask;

import com.zpf.tetris.Square.Piece;
import com.zpf.tetris.UI.MainFrame;

public class GameTask extends TimerTask {

	// Main user interface
	private MainFrame mainFrame;

	public GameTask(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void run() {

		// Get the current piece
		Piece currentPiece = this.mainFrame.getCurrentPiece();

		// Show your next piece when current get to the bottom and Block
		if (this.mainFrame.isBlock() || this.mainFrame.isButtom()) {
			this.mainFrame.showNext();
			return;
		}
		// Otherwise down 16 distance
		currentPiece.setLocationY(Piece.SQUARE_BORDER);
		this.mainFrame.getGamePanel().repaint();
	}

}
