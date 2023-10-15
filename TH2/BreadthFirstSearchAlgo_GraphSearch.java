package TH2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo_GraphSearch implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<>();
		List<Node> contain = new LinkedList();
		frontier.add(root);
		contain.contains(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				return current;
				
			}else {
				List<Node> children =current.getChildrenNodes();
				for (Node node : children) {
				if(!contain.contains(node) && !frontier.contains(node)){
					node.setParent(current);
					frontier.add(node);
					contain.add(node);
					}
				}
			//	System.out.println(frontier);
			}
			
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node startExecute = execute(root, start);
		startExecute.setParent(null);
		return execute(startExecute, goal);
	}

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		// TODO Auto-generated method stub
		return null;
	}

}
