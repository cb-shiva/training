/*
Given an array of words, create a map with the common prefix(first 3 characters) 
as key and value as the list of words that starts with that prefix.
While printing, the prefix & words starting with that prefix should 
be listed in the alphabetical order of the prefix. 
*/
package word_dictionaries;
import java.util.*;

public class WordPrefixDictionary extends WordDictionary<String>{
	
	public String getKey(String value){
		return value.substring(0,3);
	}

	public static void main(String[] args) {
		String key;
		WordPrefixDictionary w = new WordPrefixDictionary();
		String[] stringArray = {"abc","abcd","abcdef","wert","qertyui","werhjikl"};
		for(String s : stringArray){
			w.add(s);
		}

		w.displayMap();
	}
}