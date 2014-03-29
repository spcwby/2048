package draft1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI implements KeyListener {
	Main m;
	JFrame frame;
	JPanel panel = new JPanel(new GridLayout(4,4));
	JButton[][] grid = new JButton[4][4];
	ImageIcon[] tiles = {
		new ImageIcon(this.getClass().getResource("1.png")),
		new ImageIcon(this.getClass().getResource("2.png")),
		new ImageIcon(this.getClass().getResource("4.png")),
		new ImageIcon(this.getClass().getResource("8.png")),
		new ImageIcon(this.getClass().getResource("16.png")),
		new ImageIcon(this.getClass().getResource("32.png")),
		new ImageIcon(this.getClass().getResource("64.png")),
		new ImageIcon(this.getClass().getResource("128.png")),
		new ImageIcon(this.getClass().getResource("256.png")),
		new ImageIcon(this.getClass().getResource("512.png")),
		new ImageIcon(this.getClass().getResource("1024.png")),
		new ImageIcon(this.getClass().getResource("2048.png"))
	};
	
	public GUI(Main control)
	{
		m = control;
		frame = new JFrame("2048");
		frame.addKeyListener(this);
		panel.setBackground(new Color(187, 173, 160));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i =0; i<grid.length; i++)
			for(int j = 0; j<grid.length; j++) {
				grid[i][j] = new JButton();
				grid[i][j].setEnabled(false);
				panel.add(grid[i][j]);
			}
		updateBoard();
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void updateBoard()
	{
		int[][] b = m.cst.board;
		for(int i = 0; i<grid.length; i++) {
			for(int j = 0; j<grid.length; j++) {
				// hardcoded because i'm dumb
				int k = 0;
				if(b[i][j]==0) k = 0;
				if(b[i][j]==2) k = 1;
				if(b[i][j]==4) k = 2;
				if(b[i][j]==8) k = 3;
				if(b[i][j]==16) k = 4;
				if(b[i][j]==32) k = 5;
				if(b[i][j]==64) k = 6;
				if(b[i][j]==128) k = 7;
				if(b[i][j]==256) k = 8;
				if(b[i][j]==512) k = 9;
				if(b[i][j]==1024) k = 10;
				if(b[i][j]==2048) k = 11; 
				grid[i][j].setIcon(tiles[k]);
				grid[i][j].setDisabledIcon(tiles[k]);
			}
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		ArrayList<State> s = U.generateSuccessors(m.cst);
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP: 	m.cst = s.get(0); break;
		case KeyEvent.VK_DOWN:  m.cst = s.get(1); break;
		case KeyEvent.VK_LEFT:  m.cst = s.get(2); break;
		case KeyEvent.VK_RIGHT: m.cst = s.get(3); break;
		}
		m.cst.board = U.addRandomTile(m.cst.board);
		System.out.println("score: "+U.getScore(m.cst));
		updateBoard();
	}
	
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

}
