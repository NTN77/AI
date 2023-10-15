package TH2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo_TreeSearch implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if(current.getLabel().equals(goal)) {
				return current;
			}
			List<Node> child = current.getChildrenNodes();
			for (int i = child.size() - 1; i >= 0 ; i--) {
					child.get(i).setParent(current);
					frontier.add(child.get(i));
				}
		//	System.out.println(frontier);
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
