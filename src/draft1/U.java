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
		
		// goes in order: right, right, right, right
		
		State up = cloneIt(s);
		for(int i=0; i<4; i++) {
			int a = up.board[0][i], b = up.board[1][i],
				c = up.board[2][i], d = up.board[3][i];
			int[] colArr = swappy(a, b, c, d);
			up.board[0][i] = colArr[0];
			up.board[1][i] = colArr[1];
			up.board[2][i] = colArr[2];
			up.board[3][i] = colArr[3];
		}
		successors.add(up);

		State down = cloneIt(s);
		for(int i=0; i<4; i++) {
			int a = down.board[3][i], b = down.board[2][i],
				c = down.board[1][i], d = down.board[0][i];
			int[] colArr = swappy(d, c, b, a);
			down.board[0][i] = colArr[0];
			down.board[1][i] = colArr[1];
			down.board[2][i] = colArr[2];
			down.board[3][i] = colArr[3];
		}
		successors.add(down);

		State left = cloneIt(s);
		for(int i=0; i<4; i++) {

			int a = left.board[i][3], b = left.board[i][2],
				c = left.board[i][1], d = left.board[i][0];
			int[] colArr = swappy(a, b, c, d);
			left.board[i][0] = colArr[0];
			left.board[i][1] = colArr[1];
			left.board[i][2] = colArr[2];
			left.board[i][3] = colArr[3];
			
		}
		successors.add(left);

		State right = cloneIt(s);
		for(int i=0; i<4; i++) {

			int a = right.board[i][0], b = right.board[i][1],
				c = right.board[i][2], d = right.board[i][3];
			int[] colArr = swappy(d, c, b, a);
			right.board[i][0] = colArr[0];
			right.board[i][1] = colArr[1];
			right.board[i][2] = colArr[2];
			right.board[i][3] = colArr[3];
		}
		successors.add(right);
		
		return successors;
	}
	
	public static int[] swappy(int a, int b, int c, int d) {
		// [a][b][c][d] <=
		// compare c, d
		if(c==d) {
			c = c + d;
			d = 0;

			// [a][b][c+d][0] now compare a, b
			if(a==b) {
				a = a + b;
				b = c;
				c = 0;

				// [a+b][c+d][0][0]			DONE
			} else if(a==0) {
				a = b;
				b = c;
				c = 0;
				// [b][c+d][0][0]			DONE
			}

		} else if(c==0) {
			c = d;
			d = 0;

			// [a][b][d][0] now compare a, b
			if(a==b) {
				a = a + b;
				b = c;
				c = 0;

				// [a+b][d][0][0]		DONE
			} else if(a==0) {
				a = b;
				b = c;
				c = 0;

				// [b][d][0][0]			DONE
			}
		} else {
			// [a][b][c][d] now compare b and c
			if(b==c) {
				b = b+c;
				c = d;
				d = 0;

				// [a][b+c][d][0]		DONE
			} else if(b==0) {
				// [a][c][d][0]			DONE
				b = c;
				c = d;
				d = 0;
			}
		}
		
		return new int[] {a, b, c, d};
	}
	
	public static State cloneIt(State s) {
		State clone = new State();
		for(int i=0;i<4;i++) for(int j=0;j<4;j++) clone.board[i][j]=s.board[i][j];
		return clone;
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
