package Lab5;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("PuzzleMap.txt", "PuzzleGoalState.txt");

		Node initialState = p.getInitialState();
		Node tmp = new Node(initialState);
		System.out.println(initialState.equals(tmp));
//		Node goalState = p.getGoalState();
//		System.out.println(p.getInitialState());
		System.out.println("H: "+initialState.getH());
//		System.out.println(Arrays.toString(initialState.getWhiteTilePosition()));
//		System.out.println(p.getGoalState());
//		Node re = p.moveWhiteTile(initialState, 'r');
//
//		System.out.println(re);
//		System.out.println(re.getH());
//		System.out.println(initialState);
//		System.out.println(p.computeH1(tmp));
//		System.out.println(p.computeH2(tmp));
//		System.out.println(Arrays.toString(re.getWhiteTilePosition()));
//		System.out.println(p.computeH(init, goal));

		// System.out.println(p.getInitialState());
		// System.out.println(p.getGoalState());
		//
		// List<Node> children = p.getSuccessors(initialState);
		// System.out.println("Size: "+children.size());
		// for (Node child : children) {
		// System.out.println(child.getH()+" "+p.computeH(child) );
		// }
//		long timeStart = System.currentTimeMillis();
//		IPuzzleAlgo aStar = new AStarPuzzleAlgo();
//		System.out.println(aStar.execute(p));
//		long timeEnd = System.currentTimeMillis();
//		System.out.println("Time: " + (timeEnd - timeStart));
		
//		IPuzzleAlgo dfs = new DFSPuzzleAlgo();
//		System.out.println(dfs.execute(p));
		
		IPuzzleAlgo bfs = new BFSPuzzleAlgo();
		System.out.println(bfs.execute(p));
	}
}
