package lab1_2_2;

import java.util.Random;

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
	
	public Action hasMove() {
		Random random = new Random();
		int n = random.nextInt(2);
		if (this.agentLocation.equals(Environment.LOCATION_A)) {
			return n == 0 ? Environment.MOVE_RIGHT : Environment.MOVE_DOWN;
		} else if (this.agentLocation.equals(Environment.LOCATION_B)) {
			return n == 0 ? Environment.MOVE_LEFT : Environment.MOVE_DOWN;
		} else if (this.agentLocation.equals(Environment.LOCATION_C)) {
			return n == 0 ? Environment.MOVE_RIGHT : Environment.MOVE_UP;
		} else {
			return n == 0 ? Environment.MOVE_LEFT : Environment.MOVE_UP;
		}
	}
}