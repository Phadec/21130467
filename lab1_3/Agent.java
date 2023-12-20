package lab1_3;

import java.util.List;

public class Agent {
	private AgentProgram program;

	public Agent() {
	}

	public Agent(AgentProgram aProgram) {
		program = aProgram;
	}

	public List<Action> execute(Percept p, EnvironmentState envState) {
		if (program != null) {
			return program.execute(p, envState);
		}
		return (List<Action>) NoOpAction.NO_OP;
	}
}
