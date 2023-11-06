package TH5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> container = new ArrayList<>();
		Node start = model.getInitialState();
		Node goal = model.getGoalState();
		frontier.add(start);
		
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.equals(goal)) {
				return current;
				
			}
			container.add(current);
			for (Node node : model.getSuccessors(current)) {
				if(!frontier.contains(node) && !container.contains(node)) {
					frontier.add(node);
				}
			}
		}
		return null;
	}

}
