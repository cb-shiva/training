package word_dictionaries;

import java.util.*;
abstract public class WordDictionary<T>{
	HashMap<T,ArrayList<String>> map;
	
	WordDictionary(){
		map = new HashMap<T,ArrayList<String>>();
	}

	abstract public T getKey(String value);

	//Function to add new words to the dictionary
	public void add(String value){
		T key = getKey(value);
		ArrayList<String> list = map.get(key);
		if(list == null){
			list = new ArrayList<String>();
			list.add(value);
		}
		else {
			list.add(value);
		}
		map.put(key,list);
	}

	//Function to display the dictionary on console
	public void displayMap(){
		for(Map.Entry m : map.entrySet()){
			System.out.print(m.getKey()+" : ");
			ArrayList<String> list = (ArrayList<String>) m.getValue();			
			for (String word: list) {
				System.out.print(word+" ");
			}
			System.out.println();
		}
	}
}