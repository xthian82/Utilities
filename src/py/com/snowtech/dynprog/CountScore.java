package py.com.snowtech.dynprog;

/**
 * Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, 
 * find number of ways to reach the given score.
 * 
 * @author Casa
 *
 */
public class CountScore {
	 
	// Returns number of ways to reach score n
	static int count(int n)
	{
	    // table[i] will store count of solutions for
	    // value i.
	    int [] table = new int[n+1]; 
	    int i;
	 
	    // Base case (If given value is 0)
	    table[0] = 1;
	 
	    // One by one consider given 3 moves and update the table[]
	    // values after the index greater than or equal to the
	    // value of the picked move
	    for (i= 3; i<=n; i++) table[i] += table[i-3];
	    for (i= 5; i<=n; i++) table[i] += table[i-5];
	    for (i=10; i<=n; i++) table[i] += table[i-10];
	 
	    return table[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(20));
		System.out.println(count(13));
	}

}
