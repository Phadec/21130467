package Lab2.graphSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearch {

	public Node execute(Node root, String goal, int limitedDepth) {
		if (limitedDepth == 0)
			return root.getLabel().equals(goal) ? root : null;
		Stack<Node> stack = new Stack<Node>();
		List<Node> exployed = new ArrayList<Node>();
		root.setDepth(0);
		List<Node> listChildNode = root.getChildrenNodes();
		for (int i = listChildNode.size() -1; i >=0; i--) {
			listChildNode.get(i).setDepth(1);
			listChildNode.get(i).setParent(root);
			exployed.add(listChildNode.get(i));
			stack.add(listChildNode.get(i));
		}
		return executeHelp(stack, exployed, goal, limitedDepth);
	}

	public Node executeHelp(Stack<Node> stack, List<Node> exployed, String goal, int limitedDepth) {
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			if (node.getLabel().equals(goal))
				return node;
			for (Node n : node.getChildrenNodes()) {
				if (!stack.contains(n) && !exployed.contains(n)) {
					n.setDepth(1 + node.getDepth());
					if (n.getDepth() <= limitedDepth) {						
						n.setParent(node);
						stack.add(n);
					}
				}
			}
		}
		return null;
	}

}
