package kodlama.io.devs.business.abstracts;

import java.util.List;

public interface LanguageService<T> {
	
	List<T> findAll();
	T findById(int id) throws Exception;
	T save(T object) throws Exception;
    void deleteById(int id);
    void update(T object, int id);
	
	

}
