package Lab9.src.game_nim_student;

import java.util.Arrays;

public class TestNode {
	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 21 };
		node.addAll(Arrays.asList(data));
		Node node1 = new Node();
		node1.addAll(Arrays.asList(3,3,1));
		System.out.println(node1.getSuccessors());
		MinimaxAlgo algo = new MinimaxAlgo();
		algo.execute(node);
	}
}