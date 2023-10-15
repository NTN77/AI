package TH2;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NodeComparator implements Comparator<Node> {

	@Override
	public  int compare(Node o1, Node o2) {
		int re = Double.compare(o1.getPathCost(), o2.getPathCost());
		if(re == 0) {
			return o1.getLabel().compareTo(o2.getLabel());
		}else {
			return re;
		}
	}

}
