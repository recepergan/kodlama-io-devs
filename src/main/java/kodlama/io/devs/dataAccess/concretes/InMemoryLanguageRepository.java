package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoundedRangeModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository<Language> {
	
	 private static final  Logger logger = LoggerFactory.getLogger(InMemoryLanguageRepository.class);
	

	ArrayList<Language> languages;
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(0, "C#"));
		languages.add(new Language(1, "Python"));
		languages.add(new Language(2, "Java"));
		languages.add(new Language(3, "Python"));
		languages.add(new Language(4, "Python"));
		languages.add(new Language(5, "Java"));
		languages.add(new Language(6,"C#"));
	}
	
	
	@Override
	public List<Language> findAll() {
		// TODO Auto-generated method stub
		return languages;
	}

	@Override
	public Language findById(int id) {
		return languages.stream().filter(language -> language.getId()==id).findFirst().get();
	}

	@Override
	public Language saveToDatabase(Language language) {
		logger.info("Language saveToDatabadse ...");

			languages.add(language);
			return findById(language.getId());
		
	}
	

	@Override
	public void deleteFromDatabase(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOnDAtabase(Language language, int id) {
		
		Language updateLanguage = findById(id);
		
		updateLanguage.setName(language.getName());
		
	}


	


	@Override
	public Language save(Language language) {
		// TODO Auto-generated method stub
		return null;
	}

}
