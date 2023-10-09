package Task3;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String[][] LOCATION = new String[4][4];
	public static final double DIRT_RATE = 0.5;
	public static final double WALL_RATE = 0.1;

	public enum LocationState {
		CLEAN, DIRTY
	}

	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public static void LocationInit() {
		for (int i = 0; i < LOCATION.length; i++) {
			for (int j = 0; j < LOCATION[i].length; j++) {
				LOCATION[i][j] = "Location" + "[" + i + "]" + "[" + j + "]";
			}
		}
	}

	public Environment() {
		LocationInit();
		envState = new EnvironmentState();
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		// TODO
		this.agent = agent;
		envState.setAgentLocation(location);
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		// TODO
		String location = envState.getAgentLocation();
		int i = Integer.valueOf(location.substring(9, 10));
		int j = Integer.valueOf(location.substring(12, 13));
		if (action.equals(SUCK_DIRT)) {
			envState.setLocationState(envState.getAgentLocation(), LocationState.CLEAN);
		} else {
			
			if (action.equals(MOVE_DOWN)) {
				envState.setAgentLocation(LOCATION[i + 1][j]);
			}
			if (action.equals(MOVE_UP)) {
				envState.setAgentLocation(LOCATION[i - 1][j]);
			}

			if (action.equals(MOVE_RIGHT)) {
				envState.setAgentLocation(LOCATION[i][j + 1]);
			}

			if (action.equals(MOVE_LEFT)) {
				envState.setAgentLocation(LOCATION[i][j - 1]);
			}
		}

		return envState;
	}

	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		// TODO
		return new Percept(envState.getAgentLocation(), envState.getLocationState(envState.getAgentLocation()));
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);
		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);
		for (int i = 0; i < LOCATION.length; i++) {
			for (int j = 0; j < LOCATION[i].length; j++) {
				if ((es.getLocationState(LOCATION[i][j]) == LocationState.CLEAN)
						&& (es.getLocationState(LOCATION[i][j]) == LocationState.CLEAN))
					isDone = true;// if both squares are clean, then agent do not need to do any action
				
			}
		}
		es.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}
}
