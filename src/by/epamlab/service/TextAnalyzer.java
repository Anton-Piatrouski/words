package by.epamlab.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TextAnalyzer {
	private static final String REGEX = "[^A-Za-z]\\s?";
	private static final int DEFAULT_COUNT = 1;
	private Map<String, Integer> words;
	
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
	
	private void putWord(String word) {
		Integer count = words.put(word, DEFAULT_COUNT);
		
		if (count != null) {
			count++;
			words.put(word, count);
		}
	}
}
