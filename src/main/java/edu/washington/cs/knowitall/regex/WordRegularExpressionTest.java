package edu.washington.cs.knowitall.regex;

import java.util.Arrays;
import java.util.List;

import edu.washington.cs.knowitall.regex.Expression.BaseExpression;

public class WordRegularExpressionTest {

	public static void main(String[] args) {
		
		String sentence = "The US president Barack Obama is travelling to Mexico.";
		List<WordToken> tokens = Arrays.asList(
				new WordToken("The", "DT", null),
				new WordToken("US", "NNP", null),
				new WordToken("president", "NN", null),
				new WordToken("Barak", "NNP", null),
				new WordToken("Obama", "NNP", null),
				new WordToken("is", "VB", null),
				new WordToken("travelling", "VB", null),
				new WordToken("to", "TO", null),
				new WordToken("Mexico", "NN", null),
				new WordToken(".", ".", null)
			);
		//{(|<DT>|<DT><RB.*>*<VB.*>)(<NN.*><POS>?|<CD>|<PR.*><POS>?|<CC>|<RB.*>*<JJ.*>)+}
		// <.*/DT>%(S_NP)s&[ws:nouns]+<,/.>?<named|termed|called/VB.*>%(S_NP)s
		RegularExpression<WordToken> regex = compile("(?:<string='a'> | <string='an'> | <string='the'>)? <postag='JJ'>* <postag='NNP'>+ <postag='NN'>+ <postag='NNP'>+");
		Match<WordToken> found = regex.find(tokens);
		
		StringBuilder sb = new StringBuilder();
		for (WordToken token : found.groups().get(0).tokens()) {
			sb.append(token.string + " ");
		}
		System.out.println(sb.toString());
	}
	
	public static RegularExpression<WordToken> compile(String string) {
		
		RegularExpressionParser<WordToken> parser = new RegularExpressionParser<WordToken>() {

			@Override
			public BaseExpression<WordToken> factory(String string) {
				
				return new BaseExpression<WordToken>(string) {

					@Override
					public boolean apply(WordToken entity) {
						String[] arr = this.source.split("=");
						String part = arr[0];
						String quotedValue = arr[1];
						String value = quotedValue.substring(1, quotedValue.length()-1);
						if ("string".equals(part)) {
							return entity.string.equalsIgnoreCase(value);
						} else if ("postag".equals(part)) {
							return entity.postag.equalsIgnoreCase(value);
						} else if ("chunk".equalsIgnoreCase(part)) {
							return entity.chunk.equalsIgnoreCase(value);
						}
						return false;
					}
					
				};
			}
			
		};
		return parser.parse(string);
	}

}
