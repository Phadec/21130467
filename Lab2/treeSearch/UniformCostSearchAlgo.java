package Lab2.treeSearch;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> queue = new PriorityQueue<Node>((n1, n2) 
				-> Double.compare(n1.getPathCost(), n2.getPathCost()));
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.getLabel().equals(goal))
				return node;
			List<Edge> listNode = node.getChildren();
			for (Edge edge : listNode) {
				if (!queue.contains(edge.getEnd())) {
					edge.getEnd().setPathCost(edge.getBegin().getPathCost() + edge.getWeight());
					edge.getEnd().setParent(edge.getBegin());
					queue.add(edge.getEnd());
				} else if (queue.contains(edge.getEnd())){
					Node cloneNode;
					cloneNode = (Node) edge.getEnd().clone();
					cloneNode.setParent(edge.getBegin());
					cloneNode.setPathCost(edge.getBegin().getPathCost() + edge.getWeight());
					queue.add(cloneNode);
				}
				
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> queue = new PriorityQueue<Node>((n1, n2) 
				-> Double.compare(n1.getPathCost(), n2.getPathCost()));
		queue.add(root);
		boolean starting = false;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.getLabel().equals(start)) {
				starting = true;
				node.setParent(null);
				queue.clear();
			}
			if (node.getLabel().equals(goal) && starting)
				return node;
			List<Edge> listNode = node.getChildren();
			for (Edge edge : listNode) {
				if (!queue.contains(edge.getEnd())) {
					edge.getEnd().setPathCost(edge.getBegin().getPathCost() + edge.getWeight());
					edge.getEnd().setParent(edge.getBegin());
					queue.add(edge.getEnd());
				} else if (queue.contains(edge.getEnd())){
					Node cloneNode;
					cloneNode = (Node) edge.getEnd().clone();
					cloneNode.setParent(edge.getBegin());
					cloneNode.setPathCost(edge.getBegin().getPathCost() + edge.getWeight());
					queue.add(cloneNode);
				}
				
			}
		}
		return null;
	}
}
