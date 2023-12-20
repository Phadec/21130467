package Lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();
	
	

// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		initPopulation();
		int k = 0;
		while (k++ < this.MAX_ITERATIONS ) {
			List<Node> newPopulation = new ArrayList<Node>();
			for (int i = 0; i < this.POP_SIZE; i++) {
				Node x = getParentByRandomSelection();
				Node y = getParentByRandomSelection();
				Node child = reproduce(x, y);
				if(child.getH() == 0) {
					System.out.println(k);
					return child;
				}
				if (rd.nextDouble() < this.MUTATION_RATE) {
					child = this.mutate(child);
				}
				
				newPopulation.add(child);
			}
			this.population = newPopulation;
		}
		
		Collections.sort(this.population);
		Node result = this.population.get(0);
		return result;
	}

// Mutate an individual by selecting a random Queen and 
//move it to a random row.
	public Node mutate(Node node) {
		return node.selectNextRandomCandidate();

	}

//Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		Node child = new Node();
		child.generateBoard();
		int c = rd.nextInt(Node.N);
		for (int i = 0; i < c; i++) {
			child.setRow(i, x.getRow(i));
		}
		for (int i = c; i < Node.N; i++) {
			child.setRow(i, y.getRow(i));
		}
		return child;
	}

// Select K individuals from the population at random and 
//select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		int k = rd.nextInt(this.POP_SIZE);
		Node n = this.population.get(0);
		for (int i = 1; i < k; i++) {
			if (n.getH() > this.population.get(i).getH()) {
				n = this.population.get(i);
			}
		}
		return n;
	}

//Select a random parent from the population
	public Node getParentByRandomSelection() {
		int index = rd.nextInt(this.POP_SIZE);
		return this.population.get(index);
	}
}