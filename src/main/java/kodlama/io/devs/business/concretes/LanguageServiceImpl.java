package kodlama.io.devs.business.concretes;

import java.util.List;

import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;

@Service
public class LanguageServiceImpl implements LanguageService<Language> {

	private LanguageRepository languageRepository;	
	
	
	public LanguageServiceImpl(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}


	@Override
	public List<Language> findAll() {
		// TODO Auto-generated method stub
		return languageRepository.findAll();
	}


	@Override
	public Language findById(int id) throws Exception {
		if(!isIdExist(id)) throw new Exception("Id bulunamadı!");
		return (Language) languageRepository.findById(id);
	}





	@Override
	public Language save(Language language) throws Exception {
		
		if(isIdExist(language.getId())) throw new Exception("Id tekrar edemez!");
		if(isNameExist(language)) throw new Exception("İsim tekrar edemez!");
		
		return languageRepository.save(language);
	}


	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Language language, int id) {
		
		if(checkLanguageNameValid(language))
			throw new RuntimeException("Programlama Dili Boş Geçilemez ! ");
		
		if(isLanguageExists(language))
			throw new RuntimeException("Zaten Programlama dili mevcut.");
			
		
		((LanguageServiceImpl) languageRepository).update(language, id);
	}
	
	private boolean isLanguageExists(Language language) {
		
		return languageRepository.findAll().stream()
				.anyMatch(x -> ((Language) x).getName().equals(language.getName()));
	}


	private boolean checkLanguageNameValid(Language language) {
		// TODO Auto-generated method stub
		return language.getName().isEmpty() || language.getName().isBlank();
	}


	//-----------------------------------
	private boolean isNameExist(Language language) {
		
		for(Language language2 : findAll()) {
			if(language2.getName().equals(language.getName())) {
				
				return true;
			}
		}	
		
		return false;
		
		
	}
	
	private boolean isIdExist(int id) {
		
		for(Language language2 : findAll()) {
			if(language2.getId() == id) {
				return true;
			}
		}
		return false;
	}

}
