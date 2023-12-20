package Lab6.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		state = new Queen[N];
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (this.state[i].isConflict(this.state[j])) {
					heuristic++;
				}
			}
		}
		return heuristic;
	}
	
	public Node bestCandidates(List<Node> listNode) {
		listNode.sort((n1, n2) -> n1.getH() - n2 .getH());
		return listNode.get(0);
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		for (int i = 0; i < this.N; i++) {
			Node current = new Node(this.state);
			int countState = 1;
			while(countState < N) {
				current.state[i].move();
				Node node = new Node(current);
				countState++;
				result.add(node);
			}
//			current.state[i].move();
//			result.add(current);
		}
		// Enter your code here
		return result;
	}

	public Node selectNextRandomCandidate() {
		// Enter your code here
		Random r = new Random();
		int i = r.nextInt(N);
		int row = r.nextInt(N);
		Node n = new Node(this.state);
		n.state[i].setRow(row);
		return n;
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}
}
