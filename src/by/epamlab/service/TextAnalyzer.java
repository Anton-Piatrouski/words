package by.epamlab.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TextAnalyzer {
	private static final String REGEX = "[^A-Za-z]\\s?";
	private static final int DEFAULT_COUNT = 1;
	private Map<String, Integer> words;
	
	/**
	 * Splits input text on words and puts them into the map. 
	 * @param text input text to split
	 * @see TextAnalyzer#putWord(String)
	 */
	public TextAnalyzer(String text) {
		words = new HashMap<>();
		String[] keys = text.split(REGEX);
		
		for (String key : keys) {
			putWord(key.toLowerCase());
		}
	}
	
	public Map<String, Integer> getWords() {
		return words;
	}
	
	/**
	 * Returns the word and the number of occurrences for the specified word, or a message if this map doesn't contain specified word.
	 * @param word the word is to be searched
	 * @return word and number of occurrences, or message if word is not found
	 */
	public String searchWord(String word) {
		String message;
		Integer count = words.get(word.toLowerCase());
		
		if (count != null) {
			message = word + '\t' + count;
		} else {
			message = "The word is not found.";
		}
		return message;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Entry<String, Integer> entry : words.entrySet()) {
			sb.append(entry);
			sb.append('\n');
		}
		return sb.toString();
	}
	
	/**
	 * Puts word into the map as a key. Associates the number of occurrences of this word in text with the key.
	 * If the map previously contained the mapping for the key, the old value is incremented.
	 * @param word a word to put into the map
	 */
	private void putWord(String word) {
		Integer count = words.put(word, DEFAULT_COUNT);
		
		if (count != null) {
			count++;
			words.put(word, count);
		}
	}
}
