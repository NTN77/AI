package TH7;

public class Test {

	public static void main(String[] args) {
		GA_NQueenAlgo ga = new GA_NQueenAlgo();
		Node n =ga.execute();
		System.out.println(n.getH());
	}

}
