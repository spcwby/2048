package draft1;

public class Main {
	public State cst = new State(); // cst => current state
	public GUI gui;
	
	public Main()
	{
		gui = new GUI(this);
		U.addRandomTile(cst.board);
		U.addRandomTile(cst.board);
		gui.updateBoard();
		
	}
	
	public static void main(String[] args)
	{
		new Main();
	}

}
