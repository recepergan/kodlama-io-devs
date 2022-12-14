package kodlama.io.devs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.devs.entities.concretes.Language;

//CRUD --> Create, Read, Update, Delete
public interface LanguageRepository extends JpaRepository<Language, Integer> {
	

	Language findById(int id);
	Language findByName(String name);
	
	
	



}
