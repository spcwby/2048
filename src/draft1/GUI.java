package draft1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI implements KeyListener {
	JFrame frame;
	JPanel panel = new JPanel(new BorderLayout());
	Main m;
	
	public GUI(Main control)
	{
		m = control;
		frame = new JFrame("2048");
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);

		panel.setBackground(new Color(187, 173, 160));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
		frame.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP: System.out.println("up was pressed"); break;
		case KeyEvent.VK_DOWN: System.out.println("down was pressed"); break;
		case KeyEvent.VK_LEFT: System.out.println("left was pressed"); break;
		case KeyEvent.VK_RIGHT: System.out.println("right was pressed"); break;
		}
	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

}
