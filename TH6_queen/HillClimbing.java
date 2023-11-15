package TH6_queen;

public class HillClimbing {
	private int stepClimbed;
	public Node execute(Node initialState) {
		stepClimbed = 0;
		Node current = initialState;
		while(current != null) {
			if(current.getH() == 0) {
				return current;
			}else {
				boolean found = false;
				for (Node nextnode : current.generateAllCandidates()) {
					if(current.getH() > nextnode.getH()) {
						current = nextnode;
						found = true;
					}
				}
				if(!found) {
					return current;
				}else {
					stepClimbed++;
				}
			}
		}
		return 	null;
		
	}

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		int totalStepclimbed = 0;
		int totalRestart = 0;
		Node currentState = initialState;
		Node result;
		 while((result = execute(currentState)).getH() != 0){
			 currentState.generateBoard();
			 System.out.println("Attemp " + (totalRestart + 1) + ": " + stepClimbed + " steps.");
			 totalStepclimbed += stepClimbed;
			 totalRestart++;
		 }
		 System.out.println("Total steps: " + totalStepclimbed);
		 System.out.println("Total attemps: " + totalRestart);
		 
		 return result;
	}
}
