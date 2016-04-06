import by.epamlab.service.TextAnalyzer;

public class Runner {

	public static void main(String[] args) {
		String text = "The Java platform includes a collections framework. A collections framework is a unified architecture for representing and manipulating collections.";
		TextAnalyzer analyzer = new TextAnalyzer(text);
		String searchResult = analyzer.searchWord("Framework");
		
		System.out.println(analyzer);
		System.out.println(searchResult);
	}

}
