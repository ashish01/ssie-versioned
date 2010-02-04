package edu.berkeley.nlp.PCFGLA;

public class Triple {
	public int leftchild;
	public int rightchild;
	public int parent;
	
	public Triple(int l, int r, int p) {
		this.leftchild = l;
		this.rightchild = r;
		this.parent = p;
	}
}
