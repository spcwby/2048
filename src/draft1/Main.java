package draft1;

public class Main {
	public State cst = new State(); // cst => current state

	public Main()
	{
		new GUI(this);
	}
	
	public static void main(String[] args)
	{
		new Main();
	}

}
