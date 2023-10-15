package TH2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DepthLimitSearch implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}
	/* set count = 0;
	 * */

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		Stack<Node> frontier = new Stack<>();
		List<Node> container = new LinkedList<>();
		root.setDepth(0);
		frontier.add(root);
		container.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if(current.getLabel().equals(goal)) {
				return current;
			}else {
				if(current.getDepth() < limitedDepth) {
					List<Node> child = current.getChildrenNodes();
					for (int i = child.size() -1; i >= 0; i--) {
						if(!container.contains(child.get(i))&& !frontier.contains(child.get(i))) {
							container.add(child.get(i));
							child.get(i).setParent(current);
							child.get(i).setDepth(current.getDepth() + 1);
							frontier.push(child.get(i));
						}
					}
					
				}
			}
			System.out.println(frontier);
		}
		return null;
	}
	
}
