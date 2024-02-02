package com.onemanymapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {
	@Autowired
	private LanguageRepo languageRepo;
	@PostMapping("/api/language")
	public ResponseEntity<Language> saveLanguage(@RequestBody Language language){
		Language savedLanguage=languageRepo.save(language);
		return new ResponseEntity<Language>(savedLanguage,HttpStatus.CREATED);
		
	}
	@GetMapping("/api/language")
	public ResponseEntity<List<Language>> getAllLanguages(){
		List<Language> languages=languageRepo.findAll();
		return new ResponseEntity<List<Language>>(languages,HttpStatus.OK);
	}
	
	@GetMapping("/api/language/id")
	public ResponseEntity<Language> getLanguageById(@PathVariable int id ){
		Optional<Language> language=languageRepo.findById(id);
		if(language.isPresent()) {
			return new ResponseEntity<Language>(language.get(),HttpStatus.OK);
		}else {
		return new ResponseEntity<Language>(HttpStatus.NOT_FOUND);
	}
	}
		@PutMapping("/api/language/id")
		public ResponseEntity<Language> updatedLanguage(@PathVariable int id,@RequestBody Language updatedLanguage){
			Optional<Language> existinglanguage=languageRepo.findById(id);
			if(existinglanguage.isPresent()) {
				Language language=existinglanguage.get();
				language.setName(updatedLanguage.getName());
			   Language savedLanguage=languageRepo.save(language);
			
				return new ResponseEntity<Language>(savedLanguage,HttpStatus.OK);
			}else {
			return new ResponseEntity<Language>(HttpStatus.NOT_FOUND);
		}
		}
		
			@DeleteMapping("/api/language/id")
			public ResponseEntity<Void> deleteLanguage(@PathVariable int id){
				Optional<Language> language=languageRepo.findById(id);
				if(language.isPresent()){
					
				
				
					return new ResponseEntity<Void>(HttpStatus.OK);
				}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
}
}