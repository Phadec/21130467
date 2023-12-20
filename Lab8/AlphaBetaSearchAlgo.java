package Lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		// Enter your code here
		if (node.isTerminal()) return node.getValue();
		node.setValue(Integer.MIN_VALUE);
		for (Node n : node.getChildren()) {
			if (node.getValue() >= beta) {
				System.out.println(n.getLabel());
				continue;
			}
			if (node.getValue() >= beta) return node.getValue(); 
			int value = Math.max(node.getValue(), minValue(n, alpha, beta));
			node.setValue(value);
			alpha = Math.max(alpha, value);
		}
		return node.getValue();
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		if (node.isTerminal()) return node.getValue();
		node.setValue(Integer.MAX_VALUE);
		for (Node n : node.getChildren()) {
			if (node.getValue() <= alpha) {
				System.out.println(n.getLabel());
				continue;
			}
			if (node.getValue() <= alpha)return node.getValue();
			int value = Math.min(node.getValue(), maxValue(n, alpha, beta));
			node.setValue(value);
			beta = Math.min(beta, value);
		}
		return node.getValue();
	}
}
