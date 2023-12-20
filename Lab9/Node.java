package Lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		// Enter your code here
		List<Node> re = new ArrayList<Node>();
		if (!isTerminal()) {
			for (int i = 0; i < this.data.size(); i++) {
				int x = this.data.get(i)-1;
				int y = 1;
				while (x > y) {
					Node n = new Node();
					n.add(x);
					n.add(y);
					for (int j = 0; j < this.data.size(); j++) {
						if (j != i) {
							n.add(this.data.get(j));
						}
					}
					if (!re.contains(n)) re.add(n);
					x--;
					y++;
				}
			}
		}
		return re;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
		Collections.sort(this.data, DESCOMPARATOR);
		if (this.data.get(0) < 3) return true;
		return false;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return Objects.equals(data, other.data);
	}

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
