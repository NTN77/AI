package TH2;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo_GraphSearch implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		List<Node> contain = new LinkedList<>();
		frontier.add(root);
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
