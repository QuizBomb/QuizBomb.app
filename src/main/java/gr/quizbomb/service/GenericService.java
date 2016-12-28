package gr.quizbomb.service;

import java.util.List;

public interface GenericService<T> {
	
	public T create(T t);
	
	public T findById(long id);
	
	public T update(T t);
	
	public T delete(long id);
	
	public List<T> findAll();
	
}
