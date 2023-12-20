package Lab6.student;

public class Entry {
	public static void main(String[] args) {
		Node n = new Node();
		n.generateBoard();
		Node node = new Node(n);
//		node.displayBoard();
		Solution s = new Solution();
//		s.execute(node).displayBoard();
		s.executeHillClimbingWithRandomRestart(node).displayBoard();
	}
}
