package MinMax;

public class test {
	public static void main(String[] args) {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		E.setValue(3);
		Node F = new Node("F");
		F.setValue(12);
		Node G = new Node("G");
		G.setValue(8);
		Node H = new Node("H");
		H.setValue(2);
		Node I = new Node("I");
		I.setValue(4);
		Node J = new Node("J");
		J.setValue(6);
		Node K = new Node("K");
		K.setValue(14);
		Node L = new Node("L");
		L.setValue(5);
		Node M = new Node("M");
		M.setValue(2);
		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		B.addChild(E);
		B.addChild(F);
		B.addChild(G);
		C.addChild(H);
		C.addChild(I);
		C.addChild(J);
		D.addChild(K);
		D.addChild(L);
		D.addChild(M);
		
		ISearchAlgo is = new MiniMaxSearchAlgo();
		is.execute(A);
		ISearchAlgo ab = new AlphaBetaSearchAlgo();
		ab.execute(B);
		
		



	}
}
