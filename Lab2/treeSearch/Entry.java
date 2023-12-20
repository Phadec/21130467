package Lab2.treeSearch;

public class Entry {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A"); Node nodeB = new Node("B");
		Node nodeC = new Node("C"); Node nodeD = new Node("D");
		Node nodeE = new Node("E"); Node nodeF = new Node("F");
		Node nodeG = new Node("G"); Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
		Node result = algo1.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result));
		System.out.println(NodeUtils.printPath(algo1.execute(nodeS, "A", "H")));
//		
		ISearchAlgo algo2 = new DepthFirstSearchAlgo();
		System.out.println(NodeUtils.printPath(algo2.execute(nodeS, "G")));
		System.out.println(NodeUtils.printPath(algo2.execute(nodeS, "C", "E")));
//		
		ISearchAlgo algo3 = new UniformCostSearchAlgo();
		System.out.println(NodeUtils.printPath(algo3.execute(nodeS, "G"))
				+ " Path cost: " + algo3.execute(nodeS, "G").getPathCost());
		System.out.println(NodeUtils.printPath(algo3.execute(nodeS, "C", "E")));
	
		DepthLimitedSearch depth = new DepthLimitedSearch();
		System.out.println(NodeUtils.printPath(depth.execute(nodeS, "H", 1)));
	}
}
