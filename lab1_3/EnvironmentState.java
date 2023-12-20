package lab1_3; 

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import lab1_3.Environment.LocationState;

public class EnvironmentState {
	private Map<String, Environment.LocationState> state = new HashMap<String, Environment.LocationState>();
	private String agentLocation = null;//

	public EnvironmentState(int m, int n) {
		for (int i = 0; i < Environment.m; i++) {
			for (int j = 0; j < Environment.n; j++) {
				this.state.put(i+"," +j, Environment.LocationState.CLEAN);
			}
		}
		randomLocWall();
		randomLocDirty();
	}
	
	public void randomLocWall() {
		int rate_wall = (int) (Environment.RATE_WALL * Environment.m * Environment.n);
		while (rate_wall > 0) {
			Random random = new Random();
			int index1 = random.nextInt(Environment.m);
			int index2 = random.nextInt(Environment.n);
			this.state.put(index1 + "," + index2, Environment.LocationState.WALL);
			rate_wall--;
		}
	}
	
	public void randomLocDirty() {
		int rate_dirty = (int) (Environment.RATE_DIRTY * Environment.m * Environment.n);
		while (rate_dirty > 0) {
			Random random = new Random();
			int index1 = random.nextInt(Environment.m);
			int index2 = random.nextInt(Environment.n);
			if (this.state.get(index1 + "," + index2) != Environment.LocationState.WALL) {
				this.state.put(index1 + "," + index2, Environment.LocationState.DIRTY);
				rate_dirty--;
			}
		}
	}

	public void setAgentLocation(String location) {
		this.agentLocation = location;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}

	public LocationState getLocationState(String location) {
		return this.state.get(location);
	}

	public void setLocationState(String location, LocationState locationState) {
		this.state.put(location, locationState);
	}
	
	public boolean isDone() {
		return !this.state.containsValue(Environment.LocationState.DIRTY);
	}

	public void display() {
		System.out.println("Environment state: \n\t" + this.state);
	}
}