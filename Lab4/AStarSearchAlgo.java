package Lab4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new PriorityQueue<Node>((n1, n2) -> {
			return Double.compare(n1.getG() +n1.getH(), n2.getG() + n2.getH()) != 0
					? Double.compare(n1.getG() +n1.getH(), n2.getG() + n2.getH())
					: n1.getLabel().compareTo(n2.getLabel());
							
		});
		List<Node> exployed = new ArrayList<Node>();
		frontier.add(root);
		exployed.add(root);
		while (!frontier.isEmpty()) {
			Node node = frontier.poll();
			if (node.getLabel().equalsIgnoreCase(goal)) return node;
			List<Edge> edges = node.getChildren();
			for (Edge e : edges) {
				Node nodeChild = e.getEnd();
				if (!exployed.contains(nodeChild) && !frontier.contains(nodeChild)) {
					nodeChild.setParent(node);
					nodeChild.setG(node.getG() + e.getWeight());
					exployed.add(nodeChild);
					frontier.add(nodeChild);
				} else if (frontier.contains(nodeChild)) {
					if (nodeChild.getG() + nodeChild.getH() > node.getG() + e.getWeight() + nodeChild.getH()) {
						frontier.remove(nodeChild);
						nodeChild.setParent(node);
						nodeChild.setG(node.getG() + e.getWeight());
						frontier.add(nodeChild);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> frontier = new PriorityQueue<Node>((n1, n2) -> {
			return Double.compare(n1.getG() +n1.getH(), n2.getG() + n2.getH()) != 0
					? Double.compare(n1.getG() +n1.getH(), n2.getG() + n2.getH())
					: n1.getLabel().compareTo(n2.getLabel());
							
		});
		List<Node> exployed = new ArrayList<Node>();
		frontier.add(root);
		exployed.add(root);
		boolean starting = false;
		while (!frontier.isEmpty()) {
			Node node = frontier.poll();
			if (node.getLabel().equalsIgnoreCase(start)) {
				starting = true;
				node.setParent(null);
				node.setG(0);
				frontier.clear();
				exployed.clear();
			}
			if (node.getLabel().equalsIgnoreCase(goal) && starting) return node;
			List<Edge> edges = node.getChildren();
			for (Edge e : edges) {
				Node nodeChild = e.getEnd();
				if (!exployed.contains(nodeChild) && !frontier.contains(nodeChild)) {
					nodeChild.setParent(node);
					nodeChild.setG(node.getG() + e.getWeight());
					exployed.add(nodeChild);
					frontier.add(nodeChild);
				} else if (frontier.contains(nodeChild)) {
					if (nodeChild.getG() + nodeChild.getH() > node.getG() + e.getWeight() + nodeChild.getH()) {
						frontier.remove(nodeChild);
						nodeChild.setParent(node);
						nodeChild.setG(node.getG() + e.getWeight());
						frontier.add(nodeChild);
					}
				}
			}
		}
		return null;
	}
	
	public boolean isAdmissibleH(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> exployed = new ArrayList<Node>();
		frontier.add(root);
		exployed.add(root);
		while (!frontier.isEmpty()) {
			Node node = frontier.poll();
			double h = execute(root, node.getLabel(), goal).getG();
			if ( h > node.getH()) return false;
			List<Node> childNode = node.getChildrenNodes();
			for (Node n : childNode) {
				if (!exployed.contains(n) && !frontier.contains(n)) {
					exployed.add(n);
					frontier.add(n);
				}
			}
			
		}
		
		return true;
	}

}
