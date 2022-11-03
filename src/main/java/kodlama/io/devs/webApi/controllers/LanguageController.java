package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.CreateLanguageRequest;
import kodlama.io.devs.business.responses.GetAllLanguageResponse;
import kodlama.io.devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	
	@GetMapping("/getAll")
	public List<GetAllLanguageResponse> getAll() {
		
		return languageService.findAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest) {
		
		this.languageService.add(createLanguageRequest);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Language> updateLanguage(@RequestBody GetAllLanguageResponse getAllLanguageResponse, @PathVariable int id) {
		return new ResponseEntity<Language>(languageService.update(getAllLanguageResponse),HttpStatus.OK);
		
	}
	
	
	
	
}
