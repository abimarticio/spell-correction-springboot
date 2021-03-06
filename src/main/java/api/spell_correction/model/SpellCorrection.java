package api.spell_correction.model;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class SpellCorrection {
	
	Map<String, String> dictionary;
	
	public SpellCorrection(String file) throws FileNotFoundException {
		this.dictionary = loadDictionary(file);
	}
	
	 /**
	 * Returns load data in dictionary.
	 * @param file The input data, spell errors text.
	 * @return The load data in dictionary.
	 */
	public Map<String, String> loadDictionary(String file) throws FileNotFoundException {
		File data = new File(file);
		Scanner fileReader = new Scanner(data);
		ArrayList<String> list = new ArrayList<String>();
		while(fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			list.add(line);
			}
		fileReader.close();
		
		Map<String, String> dictionary = new HashMap<String, String>();
		for (int i = 0; i < list.size(); i++) {
			String words = list.get(i);
			String[] line = words.split(":");
			dictionary.put(line[1], line[0]);
		}
		return dictionary;
	}
	
	/**
	 * Returns correct word.
	 * @param text The word spelled incorrectly.
	 * @return The correction of word spelled incorrectly.
	 */
	public String getCorrection(String text) {
        Map<String, String> corrections = new HashMap<String, String>();
        for (Map.Entry<String,String> entry : dictionary.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey().strip();
            if(key.contains(",")){
            	String[] arrKey = key.split(",");
	            for(int i = 0; i < arrKey.length; i++){
	                key = arrKey[i].strip();
	                corrections.put(key, value);
            	}
            }
            else{
            	corrections.put(key, value);
            }
        }
        String correctWord = corrections.get(text);
        return correctWord;
	}
}