package api.spell_correction.model;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class SpellCorrection {
	
	/**
	 * Returns data in arraylist.
	 * @param file The input data, spell errors text.
	 * @return The data spell errors list.
	 */
	public static ArrayList<String> getDataList(File file) throws FileNotFoundException {
		Scanner fileReader = new Scanner(file);
        ArrayList<String> list = new ArrayList<String>();
        while(fileReader.hasNextLine()) {
            String data = fileReader.nextLine();
            list.add(data);
        }
        fileReader.close();
        return list;
    }
	
	/**
	 * Returns data in dictionary.
	 * @param list The input data, spell errors in arraylist.
	 * @return The switched key and value of spell errors in dictionary.
	 */
	public static Map<String, String> createDictionary(ArrayList<String> list) {
        Map<String, String> dictionary = new HashMap<String, String>();
        for (int i = 0; i < list.size(); i++) {
            String words = list.get(i);
            String[] line = words.split(":");
            dictionary.put(line[1], line[0]);
        }
        return dictionary;
    }
}