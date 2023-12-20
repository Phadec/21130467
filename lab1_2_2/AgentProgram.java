package lab1_2_2;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		if (p.getLocationState() == Environment.LocationState.DIRTY) {
			Environment.score += Environment.SCORE_SUCK + Environment.SCORE_ACTION;
			return Environment.SUCK_DIRT;
		} else {
			Environment.score += Environment.SCORE_ACTION;
			return p.hasMove();
		}
	}
}