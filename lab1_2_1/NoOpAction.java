package lab1_2_1; 

public class NoOpAction extends Action {
	public static final NoOpAction NO_OP = new NoOpAction();

	public boolean isNoOp() {
		return true;
	}
}