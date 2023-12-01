package TH9_Nim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		List<Node> child = new ArrayList<Node>();
		for (int j = 0; j < data.size(); j++) {
			int current = data.get(j);
			for (int i = 1; i <= current / 2; i++) {
				Node n = new Node();
				if (i != current - i) {
					n.add(i);
					n.add(current - 1);
					for (int k = 0; k < data.size(); k++) {
						if(k != j) {
							n.add(data.get(k));
						}
					}
					if(!child.contains(n))
					child.add(n);
				}
			}
		
		}

		return child;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		Collections.sort(data, DESCOMPARATOR);
		boolean result = data.get(0) <= 2 ? true : false;
		return result;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
