package api.spell_correction.model;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

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
}