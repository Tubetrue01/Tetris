package com.zpf.tetris.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import com.zpf.Factory.Factory;
import com.zpf.Factory.Impl.FactoryImpl;
import com.zpf.tetris.Square.Piece;
import com.zpf.tetris.Square.Square;
import com.zpf.tetris.Utils.Utils;
import com.zpf.Task.GameTask;

@SuppressWarnings({ "unused", "serial" })
public class MainFrame extends JFrame {

	// Initialize all of the image icon
	private final static ImageIcon PAUSE_ON_ICON = new ImageIcon("images/button-bg-pause-on.gif");
	private final static ImageIcon PAUSE_ICON = new ImageIcon("images/button-bg-pause.gif");
	private final static ImageIcon RESUME_ICON = new ImageIcon("images/button-bg-resume.gif");
	private final static ImageIcon RESUME_ON_ICON = new ImageIcon("images/button-bg-resume-on.gif");
	private final static ImageIcon START_ICON = new ImageIcon("images/button-bg-start.gif");
	private final static ImageIcon START_ON_ICON = new ImageIcon("images/button-bg-start-on.gif");

	// Next piece location in tool panel
	private final static int NEXT_X = 270;
	private final static int NEXT_Y = 320;

	// Make it center and down it
	private final static int BEGIN_X = Piece.SQUARE_BORDER * 6;
	private final static int BEGIN_Y = -32;

	// Game panel
	private GamePanel gamePanel;

	// Score
	private JLabel scoreTextLabel = new JLabel("Score");
	private JLabel scoreLabel = new JLabel();
	private Box scoreTextBox = Box.createHorizontalBox();
	private Box scoreBox = Box.createHorizontalBox();

	// Level Label
	private JLabel levelTextLabel = new JLabel("Level");
	private JLabel levelLabel = new JLabel();
	private Box levelTextBox = Box.createHorizontalBox();
	private Box levelBox = Box.createHorizontalBox();

	// Resume
	private JLabel resumeLabel = new JLabel();
	private Box resumeBox = Box.createHorizontalBox();

	// Pause
	private JLabel pauseLabel = new JLabel();
	private Box pauseBox = Box.createHorizontalBox();

	// Start
	private JLabel startLabel = new JLabel();
	private Box startBox = Box.createHorizontalBox();

	// Next
	private JLabel nextTextLabel = new JLabel("Next");
	private Box nextTextBox = Box.createHorizontalBox();

	/* Create toolPanel object and set it background */
	private JPanel toolPanel = new JPanel() {
		public void paintComponent(Graphics g) {
			ImageIcon icon = new ImageIcon("images/tool.jpg");

			g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
		}
	};

	// Create Box to constrain the width of the tool panel
	private Box blankBox = Box.createHorizontalBox();

	// Factory object
	private Factory factory = new FactoryImpl();

	// Current Running graphics
	private Piece currentPiece;
	// Next graphics
	private Piece nextPiece;

	// Current level
	private int currentLevel;

	// Score
	private int scores;

	// Task
	private GameTask gameTask;

	// Timer
	private Timer timer;

	// Current game array
	private Square[][] squares;

	// Pause game flag
	private boolean pause;

	public MainFrame() {
		
		currentLevel = 1;
		scores = 0;
		// Create gamePanel
		gamePanel = new GamePanel(this);

		// Create toolPanelLayout and set it from top to bottom
		BoxLayout toolPanelLayout = new BoxLayout(this.toolPanel, BoxLayout.Y_AXIS);
		this.toolPanel.setLayout(toolPanelLayout);
		this.toolPanel.setBorder(new EtchedBorder());

		// Score
		this.scoreTextLabel.setForeground(Color.WHITE);
		this.scoreTextBox.add(this.scoreTextLabel);
		this.scoreLabel.setText(String.valueOf(this.scores));
		this.scoreLabel.setForeground(Color.WHITE);
		this.scoreBox.add(this.scoreLabel);
		// Level
		this.levelTextLabel.setForeground(Color.WHITE);
		this.levelTextBox.add(this.levelTextLabel);
		this.levelLabel.setText(String.valueOf(this.currentLevel));
		this.levelLabel.setForeground(Color.WHITE);
		this.levelBox.add(this.levelLabel);
		// Resume
		this.resumeLabel.setIcon(RESUME_ICON);
		this.resumeLabel.setPreferredSize(new Dimension(3, 25));
		this.resumeBox.add(this.resumeLabel);
		// Pause
		this.pauseLabel.setIcon(PAUSE_ICON);
		this.pauseLabel.setPreferredSize(new Dimension(3, 25));
		this.pauseBox.add(this.pauseLabel);
		// Start
		this.startLabel.setIcon(START_ICON);
		this.startLabel.setPreferredSize(new Dimension(3, 25));
		this.startBox.add(this.startLabel);
		// Next
		this.nextTextLabel.setForeground(Color.WHITE);
		this.nextTextBox.add(this.nextTextLabel);

		// Place the box in the toolPanel
		this.toolPanel.add(Box.createVerticalStrut(10));
		this.toolPanel.add(scoreTextBox);
		this.toolPanel.add(Box.createVerticalStrut(10));
		this.toolPanel.add(scoreBox);
		this.toolPanel.add(Box.createVerticalStrut(10));
		this.toolPanel.add(levelTextBox);
		this.toolPanel.add(Box.createVerticalStrut(10));
		this.toolPanel.add(levelBox);
		this.toolPanel.add(Box.createVerticalStrut(15));
		this.toolPanel.add(this.resumeBox);
		this.toolPanel.add(Box.createVerticalStrut(15));
		this.toolPanel.add(this.pauseBox);
		this.toolPanel.add(Box.createVerticalStrut(15));
		this.toolPanel.add(this.startBox);
		this.toolPanel.add(Box.createVerticalStrut(30));
		this.toolPanel.add(this.nextTextBox);

		// Set the horizontal width of the box
		this.blankBox.add(Box.createHorizontalStrut(99));
		this.toolPanel.add(blankBox);

		// Add gamePanel to the center
		this.add(this.gamePanel, BorderLayout.CENTER);
		this.add(this.toolPanel, BorderLayout.EAST);
		this.setPreferredSize(new Dimension(350, 416));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(400, 100);
		this.setResizable(false);
		this.setTitle("¶íÂÞË¹·½¿é(V4.0.1 Build)");
		this.pack();
		initListeners();
	}

	/* Start Game */
	public void start() {

		initSquares(); // Initialize squares array
		if (this.timer != null)
			this.timer.cancel();
		createNext(currentLevel); // Create next piece
		currentPiece = factory.create(BEGIN_X, BEGIN_Y, 1);
		timer = new Timer(); // Create timer
		gameTask = new GameTask(this);
		int time = 1000 / this.currentLevel;
		timer.schedule(gameTask, 0, time);
		pause = false;
		currentLevel = 1;
		scores = 0;
		scoreLabel.setText(String.valueOf(this.scores));
	}

	/* Initialize Squares array */
	private void initSquares() {
		int sizeX = this.gamePanel.getWidth() / Piece.SQUARE_BORDER;
		int sizeY = this.gamePanel.getHeight() / Piece.SQUARE_BORDER;

		squares = new Square[sizeX][sizeY];

		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				squares[i][j] = new Square(Piece.SQUARE_BORDER * i, Piece.SQUARE_BORDER * j);
			}
		}

	}

	// Add Listener to the Mouse
	private void initListeners() {

		// Add pause button listener
		pauseLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				pause();
			}

			public void mouseEntered(MouseEvent e) {
				pauseLabel.setIcon(PAUSE_ON_ICON);
			}

			public void mouseExited(MouseEvent e) {
				pauseLabel.setIcon(PAUSE_ICON);
			}

		});

		// Add start button listener
		startLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				start();
			}

			public void mouseEntered(MouseEvent e) {
				startLabel.setIcon(START_ON_ICON);
			}

			public void mouseExited(MouseEvent e) {
				startLabel.setIcon(START_ICON);
			}
		});

		// Add resume button listener
		resumeLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				resume();
			}

			public void mouseEntered(MouseEvent e) {
				resumeLabel.setIcon(RESUME_ON_ICON);
			}

			public void mouseExited(MouseEvent e) {
				resumeLabel.setIcon(RESUME_ICON);
			}
		});

		// Add the keyboard listener
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 38)
					change();
				if (e.getKeyCode() == 40)
					down();
				if (e.getKeyCode() == 37)
					left(1);
				if (e.getKeyCode() == 39)
					right(1);
			}

		});

	}

	// Left Move method
	protected void left(int i) {
		if (this.pause)
			return;
		if (this.currentPiece == null)
			return;
		if (isLeftBlock())
			return;
		if (currentPiece.getMinXLocation() <= 0)
			return;
		int distance = -(Piece.SQUARE_BORDER * i);
		currentPiece.setLocationX(distance);
		this.gamePanel.repaint();

	}

	// To determine whether block of left
	private boolean isLeftBlock() {
		List<Square> square = currentPiece.getSquare();
		for (Square s : square) {
			Square block = this.getSquare(s.getBeginX() - Piece.SQUARE_BORDER, s.getBeginY());
			if (block != null)
				return true;
		}
		return false;
	}

	// Move right method
	protected void right(int i) {
		if (this.pause)
			return;
		if (this.currentPiece == null)
			return;
		if (isRightBlock())
			return;
		if (currentPiece.getMaxXLoaction() >= this.gamePanel.getWidth())
			return;
		int distance = Piece.SQUARE_BORDER * i;
		currentPiece.setLocationX(distance);
		this.gamePanel.repaint();

	}

	// To determine whether block of right
	private boolean isRightBlock() {
		List<Square> square = currentPiece.getSquare();
		for (Square s : square) {
			Square block = this.getSquare(s.getBeginX() + Piece.SQUARE_BORDER, s.getBeginY());
			if (block != null)
				return true;
		}
		return false;
	}

	// Change square
	private void change() {
		if (this.pause)
			return;
		if (this.currentPiece == null)
			return;
		this.currentPiece.change();

		int minX = this.currentPiece.getMinXLocation();

		if (minX < 0) {

			this.currentPiece.setLocationX(-minX);
		}

		int maxX = this.currentPiece.getMaxXLoaction();
		int gamePanelWidth = this.gamePanel.getWidth();

		if (maxX > gamePanelWidth) {

			this.currentPiece.setLocationX(-(maxX - gamePanelWidth));
		}
		this.gamePanel.repaint();

	}

	// Downwards
	private void down() {
		if (this.pause)
			return;
		if (this.currentPiece == null)
			return;
		if (isBlock() || isButtom())
			return;
		int distance = Piece.SQUARE_BORDER;
		currentPiece.setLocationY(distance);
		showNext();
		this.gamePanel.repaint();

	}

	// Create next piece
	private void createNext(int level) {
		this.nextPiece = this.factory.create(NEXT_X, NEXT_Y, level);
		this.repaint();
	}

	// Get the current piece
	public Piece getCurrentPiece() {

		return this.currentPiece;
	}

	public GamePanel getGamePanel() {
		return this.gamePanel;
	}

	// Determine whether block when it is downing
	public boolean isBlock() {
		List<Square> squares = this.currentPiece.getSquare();
		for (Square s : squares) {
			Square block = getSquare(s.getBeginX(), s.getBeginY() + Piece.SQUARE_BORDER);

			if (block != null)
				return true;
		}
		return false;
	}

	// To determine whether to reach the bottom
	public boolean isButtom() {

		return currentPiece.getMaxYLoaction() >= this.gamePanel.getHeight();
	}

	// Show next piece
	public void showNext() {
		if (isBlock() || isButtom()) {
			addToSquares();
			if (isLost()) {
				this.gameTask.cancel();
				this.currentPiece = null;
				JOptionPane.showConfirmDialog(this, "Game Over!", "Warning", JOptionPane.CANCEL_OPTION);
				return;
			}

			cleanRows();
			finishDown();
		}

	}

	// Append score
	private void addScore() {
		this.scores += 10;
		this.scoreLabel.setText(String.valueOf(scores));

		if (this.scores % 100 == 0) {
			this.currentLevel += 1;
			this.levelLabel.setText(String.valueOf(currentLevel));
			this.timer.cancel();
			this.timer = new Timer();
			this.gameTask = new GameTask(this);
			int time = 1000 / this.currentLevel;
			timer.schedule(gameTask, 0, time);

		}
	}

	// To determine whether lost
	private boolean isLost() {
		for (int i = 0; i < this.squares.length; i++) {
			Square s = squares[i][0];
			if (s.getImage() != null)
				return true;
		}
		return false;
	}

	// Pause the game
	private void pause() {
		this.pause = true;
		if (this.timer != null)
			this.timer.cancel();
		this.timer = null;
	}

	// Resume the game
	private void resume() {
		if (!pause)
			return;
		this.timer = new Timer();
		gameTask = new GameTask(this);
		int time = 1000 / this.currentLevel;
		timer.schedule(gameTask, 0, time);
		pause = false;

	}

	// Finish down operation
	private void finishDown() {
		this.currentPiece = this.nextPiece;
		this.currentPiece.setLocationX(-NEXT_X);
		this.currentPiece.setLocationX(BEGIN_X);
		this.currentPiece.setLocationY(-NEXT_Y);
		this.currentPiece.setLocationY(BEGIN_Y);

		createNext(currentLevel);
	}

	// Get the square with x and y from current game array
	private Square getSquare(int x, int y) {
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares[i].length; j++) {
				Square s = squares[i][j];
				if (s.getImage() != null && s.getBeginX() == x && s.getBeginY() == y)
					return s;
			}
		}
		return null;
	}

	private void addToSquares() {
		// Get all of the squares of current piece
		List<Square> squares = currentPiece.getSquare();

		for (Square square : squares) {
			for (int i = 0; i < this.squares.length; i++) {
				for (int j = 0; j < this.squares[i].length; j++) {
					Square s = this.squares[i][j];
					if (s.equals(square))
						this.squares[i][j] = square;
				}
			}
		}
		this.gamePanel.repaint();
	}

	public Square[][] getSquares() {
		return this.squares;
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (this.nextPiece == null)
			return;
		Utils.paintPiece(g, this.nextPiece);

	}

	private void cleanRows() {

		List<Integer> rowIndexs = new ArrayList<Integer>();
		for (int j = 0; j < this.squares[0].length; j++) {
			int k = 0;
			for (int i = 0; i < this.squares.length; i++) {
				Square s = this.squares[i][j];

				if (s.getImage() != null)
					k++;
			}

			if (k == this.squares.length) {

				for (int i = 0; i < this.squares.length; i++) {
					Square s = this.squares[i][j];
					s.setImage(null);
				}
				rowIndexs.add(j);
				addScore();
			}
		}
		handleDown(rowIndexs);
	}

	private void handleDown(List<Integer> rowIndexs) {

		if (rowIndexs.size() == 0)
			return;
		int minCleanRow = rowIndexs.get(0);
		int cleanRowSize = rowIndexs.size();

		for (int j = this.squares[0].length - 1; j >= 1; j--) {
			if (j < minCleanRow) {

				for (int i = 0; i < this.squares.length; i++) {
					Square s = this.squares[i][j];
					if (s.getImage() != null) {

						Image image = s.getImage();
						s.setImage(null);

						Square sdown = this.squares[i][j + cleanRowSize];
						sdown.setImage(image);
					}
				}
			}
		}
	}
}
