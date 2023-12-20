package Lab6.student;

public class Solution {
	int stepClimbed = 0;
	int stepClimbedAfterRandomRestart = 0;
	int randomRestarts = 0;
	public Node execute(Node initialState) {
		Node currentNode =initialState;
		Node node = null;
		while (true) {
			stepClimbed++;
			stepClimbedAfterRandomRestart++;
			node = currentNode.bestCandidates(currentNode.generateAllCandidates());
			if (node.getH() < currentNode.getH()) {
				currentNode = node;
			} else {
				return currentNode;					
			}
		}
	}
	
	public Node executeHillClimbingWithRandomRestart(Node initialState) {

		Node state = execute(initialState);
		while (state.getH() != 0) {
			state.generateBoard();
			randomRestarts++;
			stepClimbedAfterRandomRestart = 0;
			state = execute(state);
		}
		System.out.println("StepCLimbed: " + stepClimbed);
		System.out.println("RandomRestarts: " + randomRestarts);
		System.out.println("stepClimbedAfterRandomRestart: "+ stepClimbedAfterRandomRestart);
		return state;
	}

}
