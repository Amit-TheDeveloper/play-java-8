package com.java8.functions;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Given a paragraph, count sentences, words and letters
public class WordCount {

	public static void main(String[] args) {
		
		
		String text = "For several generations, stories from Africa have traditionally "
				+ "been passed down by word of mouth. Often, after a hard day’s work,"
				+ " the adults would gather the children together by moonlight, around"
				+ " a village fire and tell stories. This was traditionally called 'Tales by Moonlight'. "
				+ "Usually, the stories are meant to prepare young people for life, "
				+ "and so each story taught a lesson or moral."
				+ "In the African folktales, the stories reflect the culture where diverse types of "
				+ "animals abound. The animals and birds are often accorded human attributes, "
				+ "so it is not uncommon to find animals talking, singing, or demonstrating other "
				+ "human characteristics such as greed, jealousy, honesty, etc. "
				+ "The setting in many of the stories exposes the reader to the land form and "
				+ "climate within that region of Africa. References are often made to different "
				+ "seasons such as the 'dry' or 'rainy' season and their various effects on the "
				+ "surrounding vegetation and animal life. ";
		
		WordCount wordCount = new WordCount();
		
		
		//wordCount.countSentences(text);
		//wordCount.countWords(text);
		wordCount.countLetters(text);
	}
	
	// Assuming a sentence terminates at '.'
	private void countSentences(String paragraph) {
		Optional<String> input = Optional.of(paragraph);
		input.ifPresent(s -> System.out.println("Sentence count:" + getSentenceList(input).length));
	}

	private void countWords(String paragraph) {
		Optional<String> input = Optional.of(paragraph);
		
		input.ifPresent(s -> System.out.println(getWordList(input).length));
	}

	private void countLetters(String paragraph) {
		Optional<String> input = Optional.of(paragraph);
		Stream.of(getWordList(input)).flatMap(c -> c.lines()).forEach(c -> System.out.println(c));
		//Stream<Stream<String>> charStream = Stream.of(wordStream);
		//charStream.forEach(c -> c.map(d -> d.toCharArray()).map(e -> Character.valueOf(e)));
		
	}
	
	private int countVowels(String paragraph) {
		
		
		return 0;
		
	}
	
	private String[] getWordList(Optional<String> input) {
		return input.get().trim().split(" ");
	}
	
	private String[] getSentenceList(Optional<String> input) {
		return input.get().trim().split("\\.");
	}

}
