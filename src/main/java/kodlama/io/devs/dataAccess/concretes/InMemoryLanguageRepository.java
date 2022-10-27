package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoundedRangeModel;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository<Language> {

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
		Language findLanguage =languages.get(id);
		return findLanguage;
	}

	@Override
	public void saveToDatabase(Language object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFromDatabase(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOnDAtabase(Language object, int id) {
		// TODO Auto-generated method stub
		
	}

}
