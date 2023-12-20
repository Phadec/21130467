package lab1_3;

import java.util.List;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final double RATE_DIRTY = 0.2;
	public static final double RATE_WALL = 0.1;
	public static final int SCORE_SUCK = 500;
	public static final int SCORE_CANNOTMOVE = -100;
	public static final int SCORE_ACTION = -10;
	public static int score = 0;
	public static int m,n;
	
	public enum LocationState {
		CLEAN, DIRTY, WALL
	}
	
	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public Environment(int m, int n) {
		this.m = m;
		this.n= n;
		envState = new EnvironmentState(m,n);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		this.agent = agent;
		envState.setAgentLocation(location);;
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		if (action == SUCK_DIRT) {
			envState.setLocationState(envState.getAgentLocation(), LocationState.CLEAN);
		} else {
			if (action == MOVE_LEFT) {
				String[] loc = this.envState.getAgentLocation().split(",");
				int index1 = Integer.valueOf(loc[0]) - 1;
				this.envState.setAgentLocation(index1 + "," + loc[1]);
			} else if(action == MOVE_RIGHT) {
				String[] loc = this.envState.getAgentLocation().split(",");
				int index1 = Integer.valueOf(loc[0]) + 1;
				this.envState.setAgentLocation(index1 + "," + loc[1]);
			} else if (action == MOVE_DOWN) {
				String[] loc = this.envState.getAgentLocation().split(",");
				int index1 = Integer.valueOf(loc[1]) + 1;
				this.envState.setAgentLocation(loc[0] + "," + index1);
			} else {
				String[] loc = this.envState.getAgentLocation().split(",");
				int index1 = Integer.valueOf(loc[1]) - 1;
				this.envState.setAgentLocation(loc[0] + "," + index1);
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
		List<Action> listAction = agent.execute(getPerceptSeenBy(), this.envState);
		for (Action action : listAction) {
			String agentLocation = this.envState.getAgentLocation();
			EnvironmentState es = executeAction(action);
			if (action == SUCK_DIRT) {
				this.score += this.SCORE_SUCK + this.SCORE_ACTION;
			} else {
				this.score += this.SCORE_ACTION;
			}
			System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + action + "\tScore: " + score);
		}
		String agentLocation = this.envState.getAgentLocation();

		if (this.envState.isDone())	isDone = true;// if both squares are clean, then agent do not need to do any action
		this.envState.display();
		System.out.println("Agent Loc.: " + agentLocation);
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
