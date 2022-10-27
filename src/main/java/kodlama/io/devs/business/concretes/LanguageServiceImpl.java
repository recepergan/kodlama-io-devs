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
	public Language findById(int id) {
		// TODO Auto-generated method stub
		return (Language) languageRepository.findById(id);
	}


	@Override
	public Language save(Language object) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Language update(Language object) {
		// TODO Auto-generated method stub
		return null;
	}

}
