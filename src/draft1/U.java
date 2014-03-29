package draft1;

import java.util.ArrayList;
import java.util.Random;

public class U {
	public static int getScore(State s)
	{
		int score = 0;
		for(int i=0;i<4;i++) for(int j=0;j<4;j++) score+=s.board[i][j];
		return score;
	}
	
	// incomplete
	
	public static ArrayList<State> generateSuccessors(State s)
	{
		ArrayList<State> successors = new ArrayList<State>();
		
		// goes in order: up, down, left, right
		
		return successors;
	}
	
	public static int[][] addRandomTile(int[][] b)
	{
		Random r = new Random();
		boolean added = false;
		boolean[][] checked = new boolean[4][4];
		while(!added) {
			int x = r.nextInt(4), y = r.nextInt(4);
			if(!checked[x][y]) {
				if(b[x][y]==0) {
					b[x][y] = 2;
					added = true;
				}
				checked[x][y] = true;
			}
			
		}
		return b;
	}
}
