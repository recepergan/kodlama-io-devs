package kodlama.io.devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.Language;

//CRUD --> Create, Read, Update, Delete
public interface LanguageRepository<T> {
	
	List<T> findAll();
	T findById(int id);
	void saveToDatabase(T object);
	void deleteFromDatabase(int id);
	void updateOnDAtabase(T object, int id);
	
	
	



}
