package TH2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo_TreeSearch implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				return current;
			}
			else {
				List<Node> child = current.getChildrenNodes();
				for (Node node : child) {
					frontier.add(node);
					node.setParent(current);
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

}
