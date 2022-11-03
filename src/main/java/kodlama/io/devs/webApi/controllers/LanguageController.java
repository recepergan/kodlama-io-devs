package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.entities.concretes.Language;

@RestController
@RequestMapping("/api")
public class LanguageController {

	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/findAll")
	public List<Language> findAll() {
		return languageService.findAll();
		
	}
	@GetMapping("/findAll/{id}")
	public Language findAllById(@PathVariable int id) throws Exception {
		return (Language) languageService.findById(id);
		
	}
	
	@PostMapping
	public Language saveLanguage(@RequestBody Language language) throws Exception {
		
		return (Language) languageService.save(language);
	}
	
	@PutMapping
	public void update(@RequestBody Language language,@PathVariable int id) {
		languageService.update(language,id);
	}
	
	
	
	
}
