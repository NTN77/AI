package TH2;

public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
		// execute(root,goal) BFS GraphSearch
		ISearchAlgo algo1 = new BreadthFirstSearchAlgo_GraphSearch();
		Node root1 = nodeS;
		String goal1 = "G";
		Node result1 = algo1.execute(root1, goal1);
		System.out.println("BFS: " + root1.getLabel() + "->" + goal1 + ": " + NodeUtils.printPath(result1));

		// execute(root,start,goal) BFS GraphSearch
		String start2 = "A";
		Node result2 = algo1.execute(root1, start2, goal1);
		System.out.println("BFS: " + start2 + "->" + goal1 + ": " + NodeUtils.printPath(result2));
		System.out.println("---------------------");

		// execute(root,goal) DFS GraphSearch
		ISearchAlgo algo3 = new DepthFirstSearchAlgo_GraphSearch();
		Node root3 = nodeS;
		String goal3 = "G";
		Node result3 = algo3.execute(root3, goal3);
		System.out.println("DFS: " + root3.getLabel() + "->" + goal3 + ": " + NodeUtils.printPath(result3));

		// execute(root,start,goal) DFS GraphSearch
		String start4 = "A";
		Node result4 = algo3.execute(root3, start4, goal3);
		System.out.println("DFS: " + start4 + "->" + goal3 + ": " + NodeUtils.printPath(result4));

		System.out.println("----------------------");
		// execute(root,goal) BFS TreeSearch
		ISearchAlgo algo5 = new BreadthFirstSearchAlgo_TreeSearch();
		Node root5 = nodeS;
		String goal5 = "G";
		Node result5 = algo5.execute(root5, goal5);
		System.out.println("BFS: " + root5.getLabel() + "->" + goal5 + ": " + NodeUtils.printPath(result5));
		// execute(root,start,goal) BFS TreeSearch
		String start6 = "A";
		Node result6 = algo5.execute(root5, start6, goal5);
		System.out.println("BFS: " + start6 + "->" + goal5 + ": " + NodeUtils.printPath(result6));
		System.out.println("---------------------");

		// execute(root,goal) DFS TreeSearch
		ISearchAlgo algo7 = new DepthFirstSearchAlgo_TreeSearch();
		Node root7 = nodeS;
		String goal7 = "G";
		Node result7 = algo7.execute(root7, goal7);
		System.out.println("DFS: " + root7.getLabel() + "->" + goal7 + ": " + NodeUtils.printPath(result7));
		// execute(root,start,goal) BFS TreeSearch
		String start8 = "A";
		Node result8 = algo7.execute(root7, start8, goal7);
		System.out.println("DFS: " + start8 + "->" + goal7 + ": " + NodeUtils.printPath(result8));
		System.out.println("---------------------");

	}
}
