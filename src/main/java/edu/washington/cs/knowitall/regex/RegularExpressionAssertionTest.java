package edu.washington.cs.knowitall.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class RegularExpressionAssertionTest {
	
	public static void main(String[] args) {
		
		List<String> regexTokens = Arrays.asList(
			new String[] {
			"^",
			"<是>",
			"<一个>",
			"$"
		});
		List<String> matchTokens = Arrays.asList(
				new String[] {
				"这",
				"是",
				"一个",
				"测试"
			});
		
		RegularExpression<String> regex = RegularExpressionParsers.word.parse(" <是> <一个>");
		RegularExpression<String> regexEnd = RegularExpressionParsers.word.parse(" <是> <一个> $");
		RegularExpression<String> regexStart = RegularExpressionParsers.word.parse(" ^ <是> <一个>");
		RegularExpression<String> regexBoth = RegularExpressionParsers.word.parse(" ^ <是> <一个> $");
		
		
		System.out.println(matchTokens);
		System.out.println(matchTokens.subList(1, matchTokens.size()));
		System.out.println(matchTokens.subList(0, matchTokens.size()-1));
		
		System.out.println(regex);
		System.out.println(regex.apply(matchTokens));
		System.out.println(regex.apply(matchTokens.subList(1, matchTokens.size())));
		System.out.println(regex.apply(matchTokens.subList(0, matchTokens.size()-1)));
		
		/*System.out.println(regexEnd);
		System.out.println(regexEnd.apply(matchTokens));
		System.out.println(regexEnd.apply(matchTokens.subList(1, matchTokens.size())));
		System.out.println(regexEnd.apply(matchTokens.subList(0, matchTokens.size()-1)));*/
		
		/*System.out.println(regexStart);
		System.out.println(regexStart.apply(matchTokens));
		System.out.println(regexStart.apply(matchTokens.subList(1, matchTokens.size())));
		System.out.println(regexStart.apply(matchTokens.subList(0, matchTokens.size()-1)));*/
		
		System.out.println(regexBoth);
		System.out.println(regexBoth.apply(matchTokens));
		System.out.println(regexBoth.apply(matchTokens.subList(1, matchTokens.size())));
		System.out.println(regexBoth.apply(matchTokens.subList(0, matchTokens.size()-1)));
		
		
	}
}
