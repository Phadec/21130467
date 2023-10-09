package treeSearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {
	
	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.getLabel().equals(goal)) return node;
			List<Node> listNode = node.getChildrenNodes();
			for (Node n: listNode) {
				if (queue.contains(n)) {
					Node cloneNode;
					cloneNode = (Node) n.clone();
					cloneNode.setParent(node);
					queue.add(cloneNode);
				} else {
					n.setParent(node);
					queue.add(n);
				}
			}
		}
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		boolean starting = false;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.getLabel().equals(start)) {
				starting = true;
				node.setParent(null);
				queue.clear();
			}
			if (node.getLabel().equals(goal) && starting) return node;
			List<Node> listNode = node.getChildrenNodes();
			for (Node n: listNode) {
				if (queue.contains(n)) {
					Node cloneNode;
					cloneNode = (Node) n.clone();
					cloneNode.setParent(node);
					queue.add(cloneNode);
				} else {
					n.setParent(node);
					queue.add(n);
				}
			}
		}
		
		return null;
	}

}
