package Task3;

import java.util.Map;
import java.util.TreeMap;

import Task3.Environment.LocationState;

public class EnvironmentState {
	private Map<String, Environment.LocationState> state = new TreeMap<String, Environment.LocationState>();
	private String agentLocation = null;//

	public EnvironmentState() {
		for (int i = 0; i < Environment.LOCATION.length; i++) {
			for (int j = 0; j < Environment.LOCATION[i].length; j++) {
				if (Math.random() < 0.5) {
					this.state.put(Environment.LOCATION[i][j], Environment.LocationState.DIRTY);
				} else {
					this.state.put(Environment.LOCATION[i][j], Environment.LocationState.CLEAN);
				}
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

	public void display() {
		System.out.println("Environment state: \n\t" + this.state);
	}
}