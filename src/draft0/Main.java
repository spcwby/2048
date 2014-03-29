package draft0;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * objective: make a bot that presses a random arrow key for a set duration.
 * @author jtc
 *
 */
public class Main implements ActionListener {
	Random rand = new Random();
	Console c;
	
	public int randomArrowCode()
	{
		int i = rand.nextInt(1000);
		if(i<500) return KeyEvent.VK_UP;
		if(i>600) return KeyEvent.VK_LEFT;
		if(i<550) return KeyEvent.VK_DOWN;
		return KeyEvent.VK_RIGHT;
	}
	
	public Main()
	{
		c = new Console();
		c.start.addActionListener(this);
	}
	
	public void randomMoves() {
		int delay = 20, numClicks = (Integer) c.numClicks.getValue();
		try {
			Robot r = new Robot();
			while(numClicks-- > 0) {
				//r.mousePress(InputEvent.BUTTON1_MASK);
				//r.mouseRelease(InputEvent.BUTTON1_MASK);
				r.keyPress(randomArrowCode());
				if(delay!=0) Thread.sleep(delay);
				c.text.setText("remaining: "+numClicks);
			}
		}
		catch(InterruptedException e) { e.printStackTrace(); }
		catch(AWTException e) { System.out.println("failed"); }
	}
	
	public static void printProcessList()
	{
		try {
            String line;
            Process p = Runtime.getRuntime().exec("ps -e");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line); //<-- Parse data here.
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
	}
	
	public static void main(String[] args)
	{ new Main(); }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==c.start) randomMoves();
		
	}

}
