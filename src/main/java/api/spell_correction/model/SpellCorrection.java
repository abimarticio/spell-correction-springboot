package api.spell_correction.model;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class SpellCorrection {
	
	 /**
	 * Returns load data in dictionary.
	 * @param file The input data, spell errors text.
	 * @return The load data in dictionary.
	 */
	public static Map<String, String> loadDictionary(String file) throws FileNotFoundException {
		Scanner fileReader = new Scanner(file);
		ArrayList<String> list = new ArrayList<String>();
		while(fileReader.hasNextLine()) {
			String data = fileReader.nextLine();
			list.add(data);
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
	 * Returns corrections of spell errors.
	 * @param dictionary The switched key and value of spell errors in dictionary.
	 * @return The corrections of spell errors.
	 */
	public static String getCorrection(String text) {
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
        return corrections;
	}
}