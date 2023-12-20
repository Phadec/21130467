package lab1_2_1; 

public class Percept {
	private String agentLocation;
	private Environment.LocationState state;

	public Percept(String agentLocation, Environment.LocationState state) {
		this.agentLocation = agentLocation;
		this.state = state;
	}

	public Environment.LocationState getLocationState() {
		return this.state;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}
	
	public boolean isMove(Action action) {
		if (this.getAgentLocation().equals(Environment.LOCATION_A)) {
			if (action == Environment.MOVE_UP || action == Environment.MOVE_LEFT) return false;
		} else if (this.getAgentLocation().equals(Environment.LOCATION_B)) {
			if (action == Environment.MOVE_UP || action == Environment.MOVE_RIGHT) return false;
		} else if (this.getAgentLocation().equals(Environment.LOCATION_C)) {
			if (action == Environment.MOVE_DOWN || action == Environment.MOVE_LEFT) return false;
		} else {
			if (action == Environment.MOVE_DOWN || action == Environment.MOVE_RIGHT) return false;
		}
		
		return true;
	}
}