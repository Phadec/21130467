package Lab4;

import java.sql.DriverPropertyInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new PriorityQueue<Node>((n1, n2) -> {
			return Double.compare(n1.getH(), n2.getH()) != 0
					? Double.compare(n1.getH(), n2.getH())
					: n1.getLabel().compareTo(n2.getLabel());
							
		});
		List<Node> exployed = new ArrayList<Node>();
		frontier.add(root);
		exployed.add(root);
		while(!frontier.isEmpty()) {
			Node node = frontier.poll();
			if (node.getLabel().equalsIgnoreCase(goal)) return node;
			List<Node> childNode = node.getChildrenNodes();
			for (Node n : childNode) {
				if (!exployed.contains(n) && !frontier.contains(n)) {
					n.setParent(node);
					frontier.add(n);
					exployed.add(n);
				}
			}
		}
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> frontier = new PriorityQueue<Node>((n1, n2) -> {
			return Double.compare(n1.getH(), n2.getH()) != 0
					? Double.compare(n1.getH(), n2.getH())
					: n1.getLabel().compareTo(n2.getLabel());
							
		});
		boolean starting = false;
		List<Node> exployed = new ArrayList<Node>();
		frontier.add(root);
		exployed.add(root);
		while(!frontier.isEmpty()) {
			Node node = frontier.poll();
			if (node.getLabel().equalsIgnoreCase(start)) {
				starting = true;
				node.setParent(null);
				frontier.clear();
				exployed.clear();
			}
			if (node.getLabel().equalsIgnoreCase(goal) && starting) return node;
			List<Node> childNode = node.getChildrenNodes();
			for (Node n : childNode) {
				if (!exployed.contains(n) && !frontier.contains(n)) {
					n.setParent(node);
					frontier.add(n);
					exployed.add(n);
				}
			}
		}
		
		return null;
	}

}
