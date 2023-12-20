package lab1_3; 

public class TestSimpleReflexAgent {
	public static void main(String[] args) {
		Environment env = new Environment(5, 5);
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, "0,3");
		env.stepUntilDone();
	}
}
