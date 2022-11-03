package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.CreateLanguageRequest;
import kodlama.io.devs.business.responses.GetAllLanguageResponse;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;

@Service
public class LanguageServiceImpl implements LanguageService {

	private LanguageRepository languageRepository;

	public LanguageServiceImpl(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguageResponse> findAll() {

		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponse> languageResponse = new ArrayList<GetAllLanguageResponse>();

		for (Language language : languages) {
			GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());

			languageResponse.add(responseItem);
		}

		return languageResponse;
	}

	@Override
	public GetAllLanguageResponse findAllId(int id) {
		Language language = languageRepository.findById(id);
		GetAllLanguageResponse languageResponse = new GetAllLanguageResponse();

		languageResponse.setId(language.getId());
		languageResponse.setName(language.getName());

		return languageResponse;

	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {

		Language language = new Language();

		language.setName(createLanguageRequest.getName());

		this.languageRepository.save(language);
	}

	@Override
	public void update(CreateLanguageRequest createLanguageRequest,int id) throws Exception {

		checkNameValid(createLanguageRequest.getName());
		// TODO Auto-generated method stub
		Language language = languageRepository.findById(id);
		language.setName(createLanguageRequest.getName());
		languageRepository.save(language);
	}

	private void checkNameValid(String name) throws Exception {
		// TODO Auto-generated method stub
		 Language isExist = languageRepository.findByName(name);
		 	if (isExist != null){
	            throw new Exception("This name already exist!");
	        }
	        if (name.isBlank()){
	            throw new Exception("Name can't be null");
	        }
	}

}

//	@Override
//	public void delete(GetAllLanguageResponse getAllLanguageResponse) {
//		// TODO Auto-generated method stub
//		Language language = new Language();
//
//		language.setName(getAllLanguageResponse.getName());
//		language.setId(getAllLanguageResponse.getId());
//		
//		
//
//}

//	@Override
//	public Language delete(GetAllLanguageResponse getAllLanguageResponse) {
//		// TODO Auto-generated method stub
//		return null;
//	}
