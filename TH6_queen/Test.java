package TH6_queen;

public class Test {
	public static void main(String[] args) {
		Node init = new Node();
		init.generateBoard();
		init.displayBoard();
		HillClimbing h = new HillClimbing();
		h.execute(init);
		h.executeHillClimbingWithRandomRestart(init);
		System.out.println(init.getH());
	}
}
