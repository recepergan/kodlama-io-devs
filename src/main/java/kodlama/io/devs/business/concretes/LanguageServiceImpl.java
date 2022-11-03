package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UnsupportedLookAndFeelException;

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
	public void add(CreateLanguageRequest createLanguageRequest) {

		Language language = new Language();

		language.setName(createLanguageRequest.getName());

		this.languageRepository.save(language);
	}

	@Override
	public Language update(GetAllLanguageResponse getAllLanguageResponse) {

		// TODO Auto-generated method stub
		Language language = new Language();

		language.setName(getAllLanguageResponse.getName());
		language.setId(getAllLanguageResponse.getId());
		
		return languageRepository.save(language);
	}

}
