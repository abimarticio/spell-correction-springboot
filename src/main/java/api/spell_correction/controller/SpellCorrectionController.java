package api.spell_correction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.spell_correction.model.SpellCorrection;
import java.io.FileNotFoundException;

@RestController
public class SpellCorrectionController {

	@GetMapping("/spell-correction")
	public String word(@RequestParam(value="text", required=true) String text) throws FileNotFoundException {
		
	} 
}