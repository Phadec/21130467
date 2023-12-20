package lab1_2_1;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		Action action;
		if (p.getLocationState() == Environment.LocationState.DIRTY) {
			Environment.score += Environment.SCORE_SUCK + Environment.SCORE_ACTION;
			return Environment.SUCK_DIRT;
		} else {	
			do {
				action = Environment.getRandomAction();
				System.out.print("Action: " + action + "\t");
				if (p.isMove(action)) {
					Environment.score += Environment.SCORE_ACTION;
				} else {
					Environment.score += Environment.SCORE_CANNOTMOVE;
				}
				
			} while (!p.isMove(action));
		}
		
		return action;
	}
}