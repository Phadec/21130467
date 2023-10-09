package treeSearch;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			if (node.getLabel().equals(goal)) return node;
			List<Node> listNode = node.getChildrenNodes();
			for (int i = listNode.size()-1; i >= 0; i--) {
				if (stack.contains(listNode.get(i))) {
					Node cloneNode;
					cloneNode = (Node) listNode.get(i).clone();
					cloneNode.setParent(node);
					stack.add(cloneNode);
				} else {
					listNode.get(i).setParent(node);
					stack.add(listNode.get(i));
				}
			}
		}
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean starting = false;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			if (node.getLabel().equals(start)) {
				starting = true;
				node.setParent(null);
				stack.clear();
			}
			if (node.getLabel().equals(goal) && starting) return node;
			List<Node> listNode = node.getChildrenNodes();
			for (int i = listNode.size()-1; i >= 0; i--) {
				if (stack.contains(listNode.get(i))) {
					Node cloneNode;
					cloneNode = (Node) listNode.get(i).clone();
					cloneNode.setParent(node);
					stack.add(cloneNode);
				} else {
					listNode.get(i).setParent(node);
					stack.add(listNode.get(i));
				}
			}
		}
		
		return null;
	}

}
