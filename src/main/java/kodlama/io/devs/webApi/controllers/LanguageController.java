package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/getAll/id")
	public GetAllLanguageResponse getAllId(@RequestParam int id) {
		
		return languageService.findAllId(id);
	}
	
	
	
	@PostMapping("/add")
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest) {
		
		this.languageService.add(createLanguageRequest);
	}
	
	@PutMapping("/update/{id}")
	public void updateLanguage(@RequestBody CreateLanguageRequest createLanguageRequest, @PathVariable int id) throws Exception {

		languageService.update(createLanguageRequest,id);
	}
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<Language> deleteLanguage(@RequestBody GetAllLanguageResponse getAllLanguageResponse, @PathVariable int id) {
//		return new ResponseEntity<Language>(languageService.delete(getAllLanguageResponse),HttpStatus.OK);
//		
//	}
	
	
	
	
}
