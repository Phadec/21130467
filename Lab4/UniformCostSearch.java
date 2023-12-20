package Lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearch implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new PriorityQueue<Node>((n1, n2) -> {
			return Double.compare(n1.getG(), n2.getG()) != 0
					? Double.compare(n1.getG(), n2.getG())
					: n1.getLabel().compareTo(n2.getLabel());
							
		});
		List<Node> exployed = new ArrayList<Node>();
		frontier.add(root);
		exployed.add(root);
		while(!frontier.isEmpty()) {
			Node node = frontier.poll();
			if (node.getLabel().equalsIgnoreCase(goal)) return node;
			List<Edge> edges = node.getChildren();
			for (Edge e: edges) {
				Node nodeChild = e.getEnd();
				if (!exployed.contains(nodeChild) && !frontier.contains(nodeChild)) {
					nodeChild.setParent(node);
					nodeChild.setG(node.getG() + e.getWeight());
					exployed.add(nodeChild);
					frontier.add(nodeChild);
				} else if(frontier.contains(nodeChild)) {
					if (nodeChild.getG() > node.getG() + e.getWeight()) {
						nodeChild.setParent(node);
						nodeChild.setG(node.getG() + e.getWeight());
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
