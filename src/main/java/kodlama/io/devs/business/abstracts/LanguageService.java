package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.CreateLanguageRequest;
import kodlama.io.devs.business.responses.GetAllLanguageResponse;
import kodlama.io.devs.entities.concretes.Language;

public interface LanguageService {
	
	List<GetAllLanguageResponse> findAll();
	
	GetAllLanguageResponse findAllId(int id);
	
	void add(CreateLanguageRequest createLanguageRequest);

	void update(CreateLanguageRequest createLanguageRequest, int id) throws Exception;

	

//	Language delete(GetAllLanguageResponse getAllLanguageResponse);	

	
	
	

}
