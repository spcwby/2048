package draft1;

import java.util.ArrayList;

public class U {
	public static int getScore(State s)
	{
		int score = 0;
		for(int i=0;i<4;i++) for(int j=0;j<4;j++) score+=s.board[i][j];
		return score;
	}
	
	// incomplete
	public ArrayList<State> generateSuccessors(State s)
	{
		ArrayList<State> successors = new ArrayList<State>();
		return successors;
	}
}
