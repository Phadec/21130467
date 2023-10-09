package graphSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> queue = new PriorityQueue<Node>((n1, n2) -> Double.compare(n1.getPathCost(), n2.getPathCost()));
		List<Node> exployed = new ArrayList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			exployed.add(node);
			if (node.getLabel().equals(goal))
				return node;
			List<Edge> listNode = node.getChildren();
			for (Edge edge : listNode) {
				if (!exployed.contains(edge.getEnd()) && !queue.contains(edge.getEnd())) {
					edge.getEnd().setPathCost(edge.getBegin().getPathCost() + edge.getWeight());
					edge.getEnd().setParent(edge.getBegin());
					queue.add(edge.getEnd());
				} else if (queue.contains(edge.getEnd())){
					for (Node n : queue) {
						if (n.getLabel().equals(edge.getEnd().getLabel())) {
							if (n.getPathCost() > edge.getBegin().getPathCost() + edge.getWeight()) {
								edge.getEnd().setPathCost(edge.getBegin().getPathCost() + edge.getWeight());
								edge.getEnd().setParent(edge.getBegin());
							}
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> queue = new PriorityQueue<Node>((n1, n2) -> Double.compare(n1.getPathCost(), n2.getPathCost()));
		List<Node> exployed = new ArrayList<Node>();
		queue.add(root);
		boolean starting = false;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			exployed.add(node);
			if (node.getLabel().equals(start)) {
				starting = true;
				exployed.clear();
				node.setParent(null);
				queue.clear();
			}
			if (node.getLabel().equals(goal) && starting)return node;
			List<Edge> listNode = node.getChildren();
			for (Edge edge : listNode) {
				if (!exployed.contains(edge.getEnd()) && !queue.contains(edge.getEnd())) {
					edge.getEnd().setPathCost(edge.getBegin().getPathCost() + edge.getWeight());
					edge.getEnd().setParent(edge.getBegin());
					queue.add(edge.getEnd());
				} else if (queue.contains(edge.getEnd())){
					for (Node n : queue) {
						if (n.getLabel().equals(edge.getEnd().getLabel())) {
							if (n.getPathCost() > edge.getBegin().getPathCost() + edge.getWeight()) {
								edge.getEnd().setPathCost(edge.getBegin().getPathCost() + edge.getWeight());
								edge.getEnd().setParent(edge.getBegin());
							}
						}
					}
				}
			}
		}
		return null;
	}

}
