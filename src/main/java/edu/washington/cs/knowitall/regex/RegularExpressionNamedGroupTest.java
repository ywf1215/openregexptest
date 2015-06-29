package edu.washington.cs.knowitall.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegularExpressionNamedGroupTest {
	
	public static void main(String[] args) {
		
		// [<.*/NN.*><.*/CD><.*/PR.*><.*/CC>]+
		
		RegularExpression<String> regex = RegularExpressionParsers.word.parse("(<subject>: <I> | (?: <The> (<subjadj>: <crazy>)? <Mariners>)) <know> <all> <of> (<poss>: <her> | (?: <the> (<possadj>: <dirty>?) <King> <'s>)) <secrets>");

		
		String[] strs = new String[]{
				"I know all of her secrets",
				"The Mariners know all of her secrets",
				"The Mariners know all of the dirty King 's secrets",
				"The Mariners know all of the King 's secrets",
				"The crazy Mariners know all of the King 's secrets"};
		List<String> matches = Arrays.asList(strs);
		
		for (String m : matches) {
			System.out.println(regex.apply(Arrays.asList(m.split(" "))));
		}
		
		Match<String> m =regex.find(Arrays.asList("The crazy Mariners know all of the King 's secrets".split(" ")));
		System.out.println(m.groups().size());
		System.out.println(m.group("subject").text());
		System.out.println(m.group("subjadj").text());
		System.out.println(m.group("poss").text());
		System.out.println(m.group("possadj").text());
		
		m = regex.find(Arrays.asList("The Mariners know all of her secrets".split(" ")));
		System.out.println(m.groups().size());
		System.out.println(m.group("subject").text());
		System.out.println(m.group("poss").text());
		
		 
	}

}
