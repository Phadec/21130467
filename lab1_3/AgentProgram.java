package lab1_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AgentProgram {

	public List<Action> execute(Percept p, EnvironmentState envState) {// location, status
		List<Action> listAction = new ArrayList<Action>();
		if (p.getLocationState() == Environment.LocationState.DIRTY) {
			listAction.add(Environment.SUCK_DIRT);
		} else {
			int[] x = {1, 0, 0, -1};
			int[] y = {0, 1, -1, 0};
			boolean[][] visited = new boolean[Environment.m][Environment.n];
			Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
			Map<List<Integer>, List<Integer>> nodes= new HashMap<List<Integer>, List<Integer>>(); // Key: nodeChild, value nodeParent
			String[] loc_current = envState.getAgentLocation().split(",");
			queue.add(Arrays.asList(Integer.valueOf(loc_current[0]), Integer.valueOf(loc_current[1])));
			while(!queue.isEmpty()) {
				List<Integer> index = queue.poll();
				visited[index.get(0)][index.get(1)] = true;
				if (envState.getLocationState(index.get(0) + "," + index.get(1)) == Environment.LocationState.DIRTY) {
					List<Integer> node = index;
					while(node != null) {
						try {
							listAction.add(action(node.get(0) - nodes.get(node).get(0),
												  node.get(1) - nodes.get(node).get(1)));
						} catch (NullPointerException n) {
							
						}
						node = nodes.get(node);
					}
					return listAction;
				}
				
				for (int k = 0; k < 4; k++) {
					int i = x[k] + index.get(0);
					int j = y[k] + index.get(1);
					if (i >= 0 && i < Environment.m && j >= 0 && j < Environment.n && !visited[i][j] &&
						envState.getLocationState(i+","+j) != Environment.LocationState.WALL) {
						queue.add(Arrays.asList(i,j));
						visited[i][j] =true;
						nodes.put(Arrays.asList(i,j), index);
					}
				}
			}
		}
		return listAction;
	}
	
	public Action action(int x, int y) {
		if (x == -1 && y == 0) return Environment.MOVE_LEFT;
		if (x == 1 && y == 0) return Environment.MOVE_RIGHT;
		if (x == 0 && y == 1) return Environment.MOVE_DOWN;
		return Environment.MOVE_UP;
	}
}