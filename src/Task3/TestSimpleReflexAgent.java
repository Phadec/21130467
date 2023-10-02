package Task3; 

public class TestSimpleReflexAgent {
	public static void main(String[] args) {
		Environment env = new Environment();
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, Environment.LOCATION[0][0]);
		env.step(15);
	}
}
