package py.com.snowtech.string.search;

import py.com.snowtech.datastructure.graphs.Digrafo;
import py.com.snowtech.datastructure.graphs.DirectedDFS;
import py.com.snowtech.datastructure.lists.Lista;
import py.com.snowtech.datastructure.lists.Pila;

public class NFA {
	private char[] re;	//match transitions
	private Digrafo g;	//transition states
	private int M;		//number of states
	
	public NFA(String regexp) {
		M = regexp.length();
		re = regexp.toCharArray();
		g = buildTransitionDigraph();
	}
	
	private Digrafo buildTransitionDigraph() {
		Digrafo g = new Digrafo(M+1);
		Pila<Integer> ops = new Pila<Integer>();
		
		for (int i=0; i<M; i++) {
			int lp = i;
			
			if (re[i] == '(' || re[i] == '|') {
				//left parameters and OR
				ops.push(i);
			}
			else if (re[i] == ')') {
				int or = ops.pop();
				//OR
				if (re[or] == '|') {
					lp = ops.pop();
					g.addEdge(lp, or + 1);
					g.addEdge(or, i);
				}
				else lp = or;
			}
			
			//closure: needs 1-character lookahead
			if (i < M-1 && re[i+1] == '*') {
				g.addEdge(lp, i+1);
				g.addEdge(i+1, lp);
			}
			
			//metasymbols
			if (re[i] == '(' || re[i] == '*' || re[i] == ')')
				g.addEdge(i, i+1);
		}
		return g;
	}

	public boolean recognizes(String txt) {
		Lista<Integer> pc = new Lista<Integer>();
		DirectedDFS dfs = new DirectedDFS(g, 0);
		for (int v=0; v<g.V(); v++)
			if (dfs.marked(v)) pc.add(v);
		
		for (int i=0; i<txt.length(); i++) {
			Lista<Integer> match = new Lista<Integer>();
			for (int v : pc) {
				if (v == M) continue;
				if (re[v] == txt.charAt(i) || re[v] == '.')
					match.add(v + 1);
			}
			dfs = new DirectedDFS(g, match);
			pc = new Lista<Integer>();
			for (int v=0; v<g.V(); v++)
				if (dfs.marked(v)) pc.add(v);
		}
		for (int v : pc)
			if (v == M) return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		NFA nfa = new NFA("A*BC");
		
		System.out.println(nfa.recognizes("otrpet"));
		System.out.println(nfa.recognizes("BC"));
		System.out.println(nfa.recognizes("AAAAA"));
		System.out.println(nfa.recognizes("AAABC"));
		System.out.println(nfa.recognizes("ABC"));
		System.out.println(nfa.recognizes("BCABC"));
	}
}
