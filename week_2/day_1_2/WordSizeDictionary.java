/*
Given an array of words, create a map with the "length of the word" as key and value ,
as the "list of words with that length". Provide a visual representation of this in the paper ,
before start writing the code. Then print the map and the list nicely when you run the program in terminal.
*/
package word_dictionaries;
import java.util.*;
public class WordSizeDictionary extends WordDictionary<Integer>{
	public Integer getKey(String value){
		return value.length();
	}
	public static void main(String[] args) {
		WordSizeDictionary w = new WordSizeDictionary();
		String[] stringArray = {"abc","abcd","def","wert","qertyui'"};
		for(String s : stringArray){
			w.add(s);
		}

		w.displayMap();
	}
}