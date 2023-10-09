package graphSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> stack = new Stack<Node>();
		List<Node> explored = new ArrayList<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			explored.add(node);
			if (node.getLabel().equals(goal)) return node;
			List<Node> listNode = node.getChildrenNodes();
			for (int i = listNode.size()-1; i >= 0; i--) {
				if (!stack.contains(listNode.get(i)) && !explored.contains(listNode.get(i))) {
					stack.push(listNode.get(i));
					listNode.get(i).setParent(node);
				}
			}
		}
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean starting = false;
		Stack<Node> stack = new Stack<Node>();
		List<Node> explored = new ArrayList<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			explored.add(node);
			if (node.getLabel().equals(start)) {
				starting = true;
				explored.clear();
				node.setParent(null);
				stack.clear();
			}
			if (node.getLabel().equals(goal) && starting) return node;
			List<Node> listNode = node.getChildrenNodes();
			for (int i = listNode.size()-1; i >= 0; i--) {
				if (!stack.contains(listNode.get(i)) && !explored.contains(listNode.get(i))) {
					stack.push(listNode.get(i));
					listNode.get(i).setParent(node);
				}
			}
		}
		
		return null;
	}

}
