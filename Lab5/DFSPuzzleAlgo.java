package Lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSPuzzleAlgo implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<Node>();
		List<Node> exployed = new ArrayList<Node>();
		frontier.add(model.getInitialState());
		exployed.add(model.getInitialState());
		int count = 1;
		while (!frontier.isEmpty()) {
			System.out.println(count++);
			Node current = frontier.pop();
			if (current.equals(model.getGoalState())) return current;
			List<Node> listNodeState = model.getSuccessors(current);
			for (int i = listNodeState.size() -1; i>=0; i--) {
				if (!frontier.contains(listNodeState.get(i)) && 
					!(exployed.contains(listNodeState.get(i)))) {
					frontier.add(listNodeState.get(i));
					exployed.add(listNodeState.get(i));
				}
			}
		}
		
		return null;
	}

}
