package TH3;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		List<Node> container = new LinkedList<>();
		frontier.add(root);
		container.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)){
				return current;
			}else {
				List<Node> listCurrent = current.getChildrenNodes();
				for (Node node : listCurrent) {
					if(!frontier.contains(node) && !container.contains(node)) {
						node.setParent(current);
						frontier.add(node);
						container.add(node);
					}
				}
			}
			
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node begin = execute(root, start);
		begin.setParent(null);
		return execute(begin, goal);
	}

}
