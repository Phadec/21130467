package Task3;

import java.util.LinkedList;
import java.util.Queue;

public class AgentProgram {
	Queue<Action> queue = new LinkedList<>();
	public Action execute(Percept p) {// location, status
		// TODO
		String location = p.getAgentLocation();
		int i = Integer.valueOf(location.substring(9, 10));
		int j = Integer.valueOf(location.substring(12, 13));
		
		if (p.getLocationState().equals(Environment.LocationState.DIRTY)) {
			return Environment.SUCK_DIRT;
		} else {
			
				if (j == Environment.LOCATION[i].length -1 && queue.poll() == Environment.MOVE_RIGHT
						&& i != Environment.LOCATION.length -1) {
					queue.offer(Environment.MOVE_DOWN);
					return Environment.MOVE_DOWN;
				} else {
					if (j == 0 && queue.poll() == Environment.MOVE_LEFT && i != 0) {
						queue.offer(Environment.MOVE_UP);
						return Environment.MOVE_UP;
					} else {
						if (j < Environment.LOCATION[i].length -1 && queue.poll() != Environment.MOVE_LEFT) {
							queue.offer(Environment.MOVE_RIGHT);
							return Environment.MOVE_RIGHT;
						} else {
							if (j > 0 && queue.poll() != Environment.MOVE_RIGHT) {
								queue.offer(Environment.MOVE_LEFT);
								return Environment.MOVE_LEFT;
							
							} else {
								if(i == Environment.LOCATION.length -1 && j == Environment.LOCATION[i].length -1) {
									queue.offer(Environment.MOVE_LEFT);
									return Environment.MOVE_LEFT;
								}
							}
						}
					}
				}
			}
		
		return NoOpAction.NO_OP;

	}
}