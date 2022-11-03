package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.CreateLanguageRequest;
import kodlama.io.devs.business.responses.GetAllLanguageResponse;

public interface LanguageService {
	
	List<GetAllLanguageResponse> findAll();
	
	void add(CreateLanguageRequest createLanguageRequest);
	
	

}
