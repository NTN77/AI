package TH3;
public class TestAStar {
	public static void main(String[] args) {
		Node s = new Node("S", 6);
		Node b = new Node("B", 4);
		Node a = new Node("A", 4);
		Node c = new Node("C", 4);
		Node d = new Node("D", 3.5);
		Node e = new Node("E", 1);
		Node f = new Node("F", 1);
		Node g = new Node("G", 0);
		
		s.addEdge(b, 3);
		s.addEdge(a, 2);
		a.addEdge(c, 3);
		b.addEdge(d, 3);
		b.addEdge(c, 1);
		c.addEdge(e, 3);
		c.addEdge(d, 1);
		d.addEdge(f, 2);
		f.addEdge(g, 1);
		e.addEdge(g, 2);
		
//		IInformedSearchAlgo aStar = new AStarSearchAlgo();
//		Node res = aStar.execute(s, g.getLabel());
//		System.out.println(NodeUtils.printPath(res));
		IInformedSearchAlgo greeby = new GreedyBestFirstSearchAlgo();
		Node root = s;
		String start = "D";
		String goal = "G";
		Node result = greeby.execute(root, goal);
		System.out.println("Greeby Best First Search Algo"+ NodeUtils.printPath(result));
		Node result2 = greeby.execute(root, start, goal);
		System.out.println("Greeby Best First Search Algo Start :" + start + " -> " + goal + ":" +NodeUtils.printPath(result2));
		//----------------------------------
		IInformedSearchAlgo Astar = new AStarSearchAlgo();
		Node rootA = s;
		String startA = "D";
		String goalA = "G";
		Node resultA = Astar.execute(rootA, goalA);
		System.out.println("AStart Search Algo " + NodeUtils.printPath(resultA));
		Node resultA2 = Astar.execute(rootA, startA, goalA);
		System.out.println("AStart Search Algo Start :" + startA + " -> " + goalA + ":" +NodeUtils.printPath(resultA2));
	}
}
