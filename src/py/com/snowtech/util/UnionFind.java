package py.com.snowtech.util;

/*

8 - 9  1 - 0
|   |
4   6

connected(4, 6) = true
connected(4, 0) = false
connected(1, 0) = true

union(1, 9)

connected(4,0) = true

*/

public class UnionFind {
	private int [] ids;
	private int [] sz;
	
	public UnionFind(int N) {
		ids = new int[N];
		sz = new int [N];
		
		for (int i=0; i<N; i++) {
			ids[i] = i;
			sz[i] = 1;
		}
	}
	
	private int root(int i) {
		
		while (i != ids[i]) {
			ids[i] = ids[ids[i]];
			i = ids[i];
		}
		
		return i;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int pid = root(p);
		int qid = root(q);
		
		if (pid == qid) return;
		
		if (sz[pid] < sz[qid]) {
			ids[pid] = qid;
			sz[qid] += sz[pid];
		} else {
			ids[qid] = pid;
			sz[pid] += sz[qid];
		}
	}

}
