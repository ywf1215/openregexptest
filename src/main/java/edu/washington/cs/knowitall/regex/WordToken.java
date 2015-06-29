package edu.washington.cs.knowitall.regex;

public class WordToken {
	
	public String string;
	
	public String postag;
	
	public String chunk;
	
	public WordToken(String string, String postag, String chunk) {
		this.string = string;
		this.postag = postag;
		this.chunk = chunk;
	}

}
