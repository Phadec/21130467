package Lab7;

public class Entry {
	public static void main(String[] args) {
		GA_NQueenAlgo algo = new GA_NQueenAlgo();
		Node re = algo.execute();
		re.displayBoard();
		System.out.println(re.getH());
	}
}
