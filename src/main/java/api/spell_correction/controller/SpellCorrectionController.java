package api.spell_correction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.spell_correction.model.SpellCorrection;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;

@RestController
public class SpellCorrectionController {

	@GetMapping("/spell-correction")
	public String word(@RequestParam(value="text", required=true) String text) throws FileNotFoundException {
		File file = new File("src/main/resources/static/spell-errors.txt");
		ArrayList<String> list = SpellCorrection.getDataList(file);
		Map <String, String> dictionary = SpellCorrection.createDictionary(list);
		Map<String, String> corrections = SpellCorrection.newDictionary(dictionary);
		String correctWord = corrections.get(text);
		return correctWord;
	} 
}