package MinMax;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		int v = maxValue(node);
		node.setValue(v);
		System.out.println(node.getValue());
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		if(node.isTerminal()) {
			return node.getValue();
		}
		int maxvalue  = Integer.MIN_VALUE;
		List<Node> listnode = node.getChildren();
		for (Node node2 : listnode) {
			maxvalue = Math.max(maxvalue, minValue(node2));
		}
		return maxvalue;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		if(node.isTerminal()) {
			return node.getValue();
		}
		int minvalue  = Integer.MAX_VALUE;
		List<Node> listnode = node.getChildren();
		for (Node node2 : listnode) {
			minvalue = Math.min(minvalue, maxValue(node2));
		}
		return minvalue;
	}
}
