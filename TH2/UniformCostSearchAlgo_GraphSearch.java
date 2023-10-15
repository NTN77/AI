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
		contain.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				return current;
			}else {
				List<Edge> frontierList = current.getChildren();
				for (Edge edge : frontierList) {
					double newPathCost = current.getPathCost() + edge.getWeight();
					Node n = edge.getEnd();
					if(!contain.contains(n) && !frontier.contains(n)) {
							contain.add(n);
							frontier.add(n);
							n.setParent(current);
							n.setPathCost(newPathCost);
					}else if(frontier.contains(n) && newPathCost < n.getPathCost() ) {
								n.setParent(current);
								n.setPathCost(newPathCost);
					}	
					
				}
			}
//			System.out.println(frontier);
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node starts = execute(root, start);
		starts.setParent(null);
		return execute(starts, goal);
	}

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
