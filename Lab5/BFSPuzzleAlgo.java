package Lab5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSPuzzleAlgo implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> exployed = new ArrayList<Node>();
		frontier.add(model.getInitialState());
		exployed.add(model.getInitialState());
		int count = 0;
		while (!frontier.isEmpty()) {
			System.out.println(count++);
			Node current = frontier.poll();
			if (current.equals(model.getGoalState())) return current;
			List<Node> listNodeState = model.getSuccessors(current);
			for (Node node : listNodeState) {
				if (!exployed.contains(node) && !frontier.contains(node)) {
					exployed.add(node);
					frontier.add(node);
				}
			}
		}
		return null;
	}

}
