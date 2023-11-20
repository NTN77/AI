package TH7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 10000;
	List<Node> population = new ArrayList<Node>();//các con trong bàn cờ
	Random rd = new Random();
	
	// initialize the individuals of the population
	public void initPopulation() { // tạo các cá thể con
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}
	/*
	 * Tạo ra 1 Node cha và node mẹ
	 * cho lai vs nhau tạo ra node con
	 * node con tiếp tục lai với nhau*/
	public Node execute() {
		initPopulation();
		int k =0;
		while (k++ < MAX_ITERATIONS) {
			List<Node> newPopulation = new ArrayList<>();
			for (int i = 0; i < POP_SIZE; i++) {
				Node x = getParentByRandomSelection();
				Node y = getParentByRandomSelection();
				Node child = reproduce(x, y);
				if(rd.nextDouble() < MUTATION_RATE) {
					mutate(child);
				}
//				System.out.println("Time: "+k);
//				child.displayBoard();
				if(child.getH() == 0) {
					return child;
				}else {
					newPopulation.add(child);
				}
			}
			population = newPopulation;
		}
		Collections.sort(population);
		return population.get(0);
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) { //đột biến (lấy ngẫu nhiên 1 con di chuyển đến 1 hàng ngẫu nhiên)
		int index = rd.nextInt(node.N);
		int child = rd.nextInt(node.N);
		node.setRow(child,index);
		
	}

	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) { //lai ghép
		int c = rd.nextInt(Node.N);
		Node result = new Node();
		result.generateBoard();
		for (int i = 0; i < c; i++) {
			result.setRow(i, x.getRow(i));
		}
		for (int i = c; i < Node.N; i++) {
			result.setRow(i, y.getRow(i));
		}
		return result;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	// Chọn ngẫu nhiên K cá thể từ quần thể và 
	// chọn ra cá thể tốt nhất trong số này để trở thành bố mẹ.
	public Node getParentByTournamentSelection(int k) { 
		List<Node> listpopulation = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			listpopulation.add(getParentByRandomSelection());
		}
		Collections.sort(listpopulation);
		return listpopulation.get(0);
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() { //lấy cá thể mẹ ba ngẫu nhiên
		Node parent = population.get(rd.nextInt(POP_SIZE));
		return parent;
	}
}
