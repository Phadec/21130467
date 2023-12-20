package Lab8;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		maxValue(node);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		if (node.isTerminal()) return node.getValue();
		node.setValue(Integer.MIN_VALUE);
		for (Node n: node.getChildren()) {
			int value = Math.max(node.getValue(), minValue(n));
			node.setValue(value);
		}
		System.out.println(node.getLabel() + ": " + node.getValue());
		return node.getValue();
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		if (node.isTerminal()) return node.getValue();
		node.setValue(Integer.MAX_VALUE);
		for (Node n: node.getChildren()) {
			int value = Math.min(node.getValue(), maxValue(n));
			node.setValue(value);
		}
		System.out.println(node.getLabel() + ": " + node.getValue());
		return node.getValue();
	}
}
