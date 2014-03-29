package draft0;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

public class Console {

	JFrame frame = new JFrame("2048 AI");
	JPanel panel = new JPanel();
	JButton start = new JButton("start");
	JSpinner numClicks = new JSpinner(new SpinnerNumberModel(10, 1, 10000, 1));
	JTextArea text = new JTextArea();
	JFrame frame2 = new JFrame("2048 AI Console");

	JPanel panel2 = new JPanel();
	public Console() {
		panel.add(start);
		panel.add(numClicks);
		panel2.add(text);
		frame.setSize(200, 100);
		frame.add(panel);
		frame2.setSize(200, 100);
		frame2.add(panel2);
		frame2.setResizable(false);
		frame2.setVisible(true);
		frame2.setLocationRelativeTo(frame);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	

}
