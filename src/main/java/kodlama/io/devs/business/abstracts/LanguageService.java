package kodlama.io.devs.business.abstracts;

import java.util.List;

public interface LanguageService<T> {
	
	List<T> findAll();
	T findById(int id);
	T save(T object);
    void deleteById(int id);
    T update(T object);
	
	

}
