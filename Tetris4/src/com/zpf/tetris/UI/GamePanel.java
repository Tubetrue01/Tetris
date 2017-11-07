package com.zpf.tetris.UI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import com.zpf.tetris.Utils.Utils;
import com.zpf.tetris.Square.Square;
import com.zpf.tetris.Square.Piece;;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	MainFrame mainFrame;

	// Get the background picture
	private Image background = Utils.getImage("images/background.jpg");

	public GamePanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	public void paint(Graphics g) {
		g.drawImage(this.background, 0, 0, this.getWidth(), 
				this.getHeight() , null);
		Piece currentPiece = this.mainFrame.getCurrentPiece();
		Utils.paintPiece(g, currentPiece);
		Square[][] squares = this.mainFrame.getSquares();
		if (squares == null) return;
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				Square s = squares[i][j];
				if (s != null) {
					g.drawImage(s.getImage(), s.getBeginX(), s.getBeginY(), this);
				}
			}
		}
	}


}
